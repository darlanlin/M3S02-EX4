package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cadastro Servlet", urlPatterns = "/cadastro.do")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1>Informações enviadas com sucesso!</h1>");

        String aluno = req.getParameter("aluno");
        String disciplina = req.getParameter("disciplina");
        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");
        String n3 = req.getParameter("n3");
        String n4 = req.getParameter("n4");
        double median = (Double.parseDouble(n1)+Double.parseDouble(n2)+Double.parseDouble(n3)+Double.parseDouble(n4))/4;


            writer.println("<ul>");
            writer.println("Olá aluno(a) "+aluno+", suas notas são nota 1: "+n1+", nota 2: "+n2+", nota 3: "+n3+", nota 4: "+n4+" e sua média na disciplina "+disciplina+" foi: "+median+".");
            writer.println("</ul>");

            if (median >= 7) {
                writer.println("<ul>O aluno está APROVADO</ul>");
            } else if (median >= 6) {
                writer.println("<ul>O aluno está EM RECUPERAÇÃO</ul>");
            } else {
                writer.println("<ul>O aluno está REPROVADO</ul>");
            }

    }
}
