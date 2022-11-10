package app;

import static spark.Spark.*;

import java.util.HashMap;

import dao.QuizDAO;
import dao.UsuarioDAO;
import model.Quiz;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
	static UsuarioDAO daoUs = new UsuarioDAO();
	static QuizDAO daoQuiz = new QuizDAO();
	static Usuario usuarioLogado = null;
	public static void main(String[] args) {
		port(4567);
		daoUs.getAll();
		VelocityTemplateEngine vte = new VelocityTemplateEngine();
		staticFiles.location("/public");
		get("/home", App::home, vte);
		get("/home2", App::home2, vte);
		get("/quiz", App::quiz, vte);
		post("/quiz", App::saveQuiz);
		get("/perfil", App::perfil, vte);
		get("/login", App::login, vte);
        get("/cadastro", App::cadastro, vte);
        get("/sair", App::sair, vte);
        post("/cadastro", App::generateCadastro);
        
    }
	
	public static ModelAndView home(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		model.put("usuario", usuarioLogado);
		return new ModelAndView(model, "view/home.vm");
	}
	public static ModelAndView home2(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		model.put("usuario", usuarioLogado);
		return new ModelAndView(model, "view/home2.vm");
	}
	
	
	public static ModelAndView quiz(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		model.put("usuario", usuarioLogado);
		return new ModelAndView(model, "view/quiz.vm");
	}
	
	public static Object saveQuiz(Request req, Response res) {
		String r1 = req.queryParams("r1");
		String r2 = req.queryParams("r2");
		String r3 = req.queryParams("r3");
		String r4 = req.queryParams("r4");
		int usuarioId = usuarioLogado.getId();
		System.out.println("chamou");
		daoQuiz.insert(new Quiz(r1, r2, r3, r4, usuarioId));
		res.redirect("/home");
		return "ok";
	}
	
	public static ModelAndView perfil(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		model.put("usuario", usuarioLogado);
		return new ModelAndView(model, "view/perfil.vm");
	}
	
	public static ModelAndView login(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		String email = req.queryParams("email");
		String senha = req.queryParams("password");
		System.out.println("login main " + email + " " + senha);
		if(email != null && senha != null) {
			usuarioLogado = (daoUs.getUsuario(email, senha)).clone();
			System.out.println(usuarioLogado.toString());
			if(usuarioLogado != null) {
				res.redirect("/home2");
				return new ModelAndView(model, "view/home2.vm");
			}
		}
		return new ModelAndView(model, "view/login.vm");
	}
	
	public static ModelAndView sair(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		String email = req.queryParams("email");
		String senha = req.queryParams("password");
		System.out.println("login main " + email + " " + senha);
		if(email != null && senha != null) {
			usuarioLogado = null;
		System.out.println(usuarioLogado);
		if(usuarioLogado==null) {
			res.redirect("/login");
			return new ModelAndView(model, "view/login.vm");
			}
		}
		return new ModelAndView(model, "view/home2.vm");
	}
	
	public static ModelAndView cadastro(Request req, Response res) {
		HashMap<String, Object> model = new HashMap<>();
		
		return new ModelAndView(model, "view/cadastro.vm");
	}
	
	public static Object generateCadastro(Request req, Response res) {
		String nome = req.queryParams("nome");
		String email = req.queryParams("email");
		String password = req.queryParams("password");
		System.out.println(nome + " " + email + " " + password);
		daoUs.insert(new Usuario(nome, email, password));
		res.redirect("/login");
		return "ok";
	}
}