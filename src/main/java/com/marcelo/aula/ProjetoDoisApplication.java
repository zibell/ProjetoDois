package com.marcelo.aula;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.aula.dao.CursoDAO;
import com.marcelo.aula.dao.TurmaDAO;
import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.entity.TurmaEntity;

@SpringBootApplication
public class ProjetoDoisApplication implements CommandLineRunner{
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@Autowired
	private TurmaDAO turmaDAO;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDoisApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
											//id, descrião, nivel e turma
//		CursoEntity curso1 = new CursoEntity(null, "Sistemas para Internet", "Superior", "Noturno");
//		CursoEntity curso2 = new CursoEntity(null, "Biologia", "Superior", "Diurno");
		
//		TurmaEntity turma1 = new TurmaEntity(null, "Formandos", 6, curso1);
//		TurmaEntity turma2 = new TurmaEntity(null, "Fresh", 5, curso2);
//		TurmaEntity turma3 = new TurmaEntity(null, "Meio Termo", 4, curso2);
		
//		curso1.getTurma().addAll(Arrays.asList(turma1, turma3));
//		curso2.getTurma().addAll(Arrays.asList(turma2));
		
//		cursoDAO.saveAll(Arrays.asList(curso1, curso2));
//		turmaDAO.saveAll(Arrays.asList(turma1, turma2, turma3));
		
	}

}
