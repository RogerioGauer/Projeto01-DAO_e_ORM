package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.CursoDAO;

/**
 *
 * @author Rogerio
 */
public class CursoController extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "";        
        //Pega o parâmetro de controle que veio do form.
        String tip = request.getParameter("tip");
        
        if (tip.equalsIgnoreCase("insert")){  
            try {
                //Pegar os dados.
                String nom = request.getParameter("nom");
                String des = request.getParameter("des");
                String val = request.getParameter("val");
                
                //Criar o objeto curso.
                Curso obj = new Curso();
                 //Ajustar usando os SET's.
                obj.setNome(nom);
                obj.setDescricao(des);
                obj.setValor(Double.parseDouble(val));                              
 
                //Criar o objeto DAO.
                CursoDAO dao = new CursoDAO();
                //Usar o método de inserção => dao.inserir(obj).     
                int res = dao.inserir(obj);                                
                    if (res > 0){
                        msg = "ok";
                    }
                    else{
                        msg = "bug1";
                    }
            } 
            catch (Exception e){
                System.out.println(e.getMessage());
                msg = "bug2";
            }
        }        
        else if (tip.equalsIgnoreCase("update")){
            try {
                //Pegar os dados.
                String cod = request.getParameter("cod");
                String nom = request.getParameter("nom");
                String des = request.getParameter("des");
                String val = request.getParameter("val");
                
                //Criar o objeto curso.
                Curso obj = new Curso();
                 //Ajustar usando os SET's.
                obj.setCodigo(Long.parseLong(cod)); 
                obj.setNome(nom);
                obj.setDescricao(des);
                obj.setValor(Double.parseDouble(val));                                
 
                //Criar o objeto DAO.                
                CursoDAO dao = new CursoDAO();
                //Usar o método de atualizar => dao.atualizar(obj).                   
                int res = dao.atualizar(obj);                                
                    if (res > 0){
                        msg = "ok";
                    }
                    else{
                        msg = "bug1";
                    }
            } 
            catch (Exception e){
                System.out.println(e.getMessage());
                msg = "bug2";
            }            
        }
        
        /* O método para deletar poderia ser por POST, mas será por GET.
        
        else if (tip.equalsIgnoreCase("delete")){
              try {
                //Pegar o código enviado.
                String cod = request.getParameter("cod");
                               
                //Criar o objeto curso.
                Curso obj = new Curso();
                 //Ajustar usando o SET específico.
                obj.setCodigo(Long.parseLong(cod));                                               
 
                //Criar o objeto DAO.
                CursoDAO dao = new CursoDAO();
                //Usar o método para excluir => dao.excluir(obj).        
                int res = dao.excluir(obj);                                
                    if (res > 0){
                        msg = "ok";
                    }
                    else{
                        msg = "bug1";
                    }
            } 
            catch (Exception e){
                msg = "bug2";
            } 
        }        
        */
        
        response.sendRedirect("index.jsp?msg="+msg);       
    }
    
    /**
     * Método exclusivo para deletar um registro, enviando o "tip" e código por GET
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processDelete(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String msg = "";        
        //Pega o parâmetro de controle que veio do form.
        String tip = request.getParameter("tip");
        
        if (tip.equalsIgnoreCase("delete")){
              try {
                //Pegar o código enviado.
                String cod = request.getParameter("cod");
                               
                //Criar o objeto curso.
                Curso obj = new Curso();
                 //Ajustar usando o SET específico.
                obj.setCodigo(Long.parseLong(cod));                                               
 
                //Criar o objeto DAO.
                CursoDAO dao = new CursoDAO();
                //Usar o método para excluir => dao.excluir(obj).        
                int res = dao.excluir(obj);                                
                    if (res > 0){
                        msg = "ok";
                    }
                    else{
                        msg = "bug1";
                    }
            } 
            catch (Exception e){
                System.out.println(e.getMessage());
                //e.printStackTrace();
                msg = "bug2";
            } 
        }
        
        response.sendRedirect("index.jsp?msg="+msg);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        processDelete(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
