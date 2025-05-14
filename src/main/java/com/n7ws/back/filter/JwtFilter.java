package com.n7ws.back.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.n7ws.back.config.JwtUtils;
import com.n7ws.back.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter{

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtils jwtUtils;

    @Override
    /** Filter ayant pour objectif de filter les requetes qui ont besoin d'authentication (routes privées) et les autres (routes publiques)
     *  Objectif de ce filtre est de vérifier si le token JWT est valide et d'authentifier l'utilisateur dans le cadre d'une requête sur une route privée
     *  */
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Récupération du token JWT dans l'en-tête Authorization
            jwt = authHeader.substring(7); // Récupération du token après "Bearer "
            username = jwtUtils.extractUid(jwt);
        }

        // Vérification si l'utilisateur est déjà authentifié
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
            
            if (jwtUtils.validateToken(username, jwt)) {
                // Le token est valide, on peut authentifier l'utilisateur

                // Créer un token d'authentification
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // On ajoute dans les details du token la source d'authentification du token, sert à du debug et des logs
                authenticationToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response); // On continue la chaîne de filtres si il y en a (pas notre cas ?)

    }
}
