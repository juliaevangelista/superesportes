package edu.pw2.superesportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pw2.superesportes.config.SecurityConfig;
import edu.pw2.superesportes.model.usuario.Usuario;
import edu.pw2.superesportes.model.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping("cadastro")
    public String loadUsuarioForm(){
        return "usuario/cadastro";
    }
    @PostMapping("salvar")
    @Transactional
    public String salvarUsuario(String username, String password){
        SecurityConfig sc = new SecurityConfig();
        String digest = sc.passwordEncoder().encode(password);
        Usuario u = new Usuario(username, password);
        usuarioRepo.save(u);
        return "redirect:/login";
    }
}
