package com.deliveryApp.Delivery.security.oauth2;

import com.deliveryApp.Delivery.exception.OAuth2AuthenticationProcessingException;
import com.deliveryApp.Delivery.security.UserPrincipal;
import com.deliveryApp.Delivery.security.oauth2.user.OAuth2UserInfo;
import com.deliveryApp.Delivery.security.oauth2.user.OAuth2UserInfoFactory;
import com.deliveryApp.Delivery.sociale.types.AuthProvider;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<user> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        user User;
        if(userOptional.isPresent()) {
        	User = userOptional.get();
            if(!User.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                		User.getProvider() + " account. Please use your " + User.getProvider() +
                        " account to login.");
            }
            User = updateExistingUser(User, oAuth2UserInfo);
        } else {
        	User = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(User, oAuth2User.getAttributes());
    }

    private user registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        user User = new user();

        User.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        User.setProviderid(oAuth2UserInfo.getId());
        User.setUserName(oAuth2UserInfo.getName());
        User.setEmail(oAuth2UserInfo.getEmail());
        User.setImageUrl(oAuth2UserInfo.getImageUrl());
        return userRepository.save(User);
    }

    private user updateExistingUser(user existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setUserName(oAuth2UserInfo.getName());
        existingUser.setImageUrl(oAuth2UserInfo.getImageUrl());
        return userRepository.save(existingUser);
    }

}
