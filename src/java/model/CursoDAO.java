package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rogerio
 */

public class CursoDAO {
    //Declaração de variáveis.
    Connection conn;    
    
    /**
     * Método construtor da classe.
     * Sempre que criar um objeto, chama este método.
     */
    public CursoDAO(){
        try{
            //Conectar com o banco de dados.
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost/alfajava";
            String user = "root";
            String pass = "";
            this.conn = DriverManager.getConnection(host, user, pass);       
        }
        catch(Exception e){
            this.conn = null;
        }
    }
    
    /**
     * Método para listar os cursos.
     * @return List<Curso>
     */
    public List<Curso> listar(){
        List<Curso> lista = new ArrayList<Curso>();
        
        try{
            //Criar um objeto para a manipulação dos SQL's.
            Statement stmt = this.conn.createStatement();

            //Criar o comando e executar.
            String sql = "select * from curso";
            ResultSet rset = stmt.executeQuery(sql); 

            //Manipular o resultado.        
            while (rset.next()){ //Enquanto houver linhas no rset.
                Curso obj = new Curso();
                obj.setCodigo (rset.getLong("codigo"));
                obj.setNome (rset.getString ("nome"));
                obj.setDescricao (rset.getString ("descricao"));
                obj.setValor (rset.getDouble ("valor"));
                //Adicionar o obj em uma lista.
                lista.add(obj);
            }

            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            lista = null;
        }
      
        return lista;    
    }   
    
    /**
     * Método para ser usado como JavaBean getCursos().
     * @return 
     */
    public List<Curso> getCursos(){
        return listar();
    }    
        
    /**
     * Método para buscar um curso específico.
     * @param filtro
     * @return Curso
     */
    public Curso buscar(String filtro){
        //List<Curso> lista = new ArrayList<Curso>();
        Curso obj = new Curso();
        try{
            //Criar um objeto para a manipulação dos SQL's.
            Statement stmt = this.conn.createStatement();

            //Criar o comando e executar.
            String sql = "select * from curso where "+filtro;
            ResultSet rset = stmt.executeQuery(sql); 

            //Manipular o resultado.        
            while (rset.next()){ //Enquanto houver linhas no rset.
                //Curso obj = new Curso();
                obj.setCodigo(rset.getLong("codigo"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setValor(rset.getDouble("valor"));
                //Adicionar o obj em uma lista.
                //lista.add(obj);
            }

            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            obj = null;
        }      
        return obj;    
    }   
    
    /**
     * Método para cadastrar um novo curso.
     * @param obj 
     * @return  
     */
    public int inserir(Curso obj){       
        //Declaração de variável.
        int res = 0;
        //Pega os parâmetros.      
        String nom = obj.getNome();
        String des = obj.getDescricao();
        Double val = obj.getValor();
         //Monta o comando SQL para inserção.
        String sql = "insert into curso (nome, descricao, valor) values (?, ?, ?)";   
        //Executa.             
        try{         
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setDouble(3, val);
            //Se conseguir inserir um comando na tabela, "res" será maior que 0.
            res = stmt.executeUpdate();
            //Fecha os objetos de manipulação do SGBD.
            stmt.close();
            this.conn.close();    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            res = 0;
        }                
        
        return res;
    }
    
    /**
     * Método para atualizar um curso específico.
     * @param obj 
     * @return  
     */
    public int atualizar(Curso obj){
        //Declaração de variável.
        int res = 0;
        //Pega os parâmetros. 
        String nom = obj.getNome();
        String des = obj.getDescricao();
        Double val = obj.getValor();
        Long cod = obj.getCodigo();        
        //Monta o comando SQL para atualização.
        String sql = "update curso set nome=?, descricao=?, valor=? where codigo=?";          
        //Executa.         
        try{         
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setDouble(3, val);
            stmt.setLong(4, cod);
            //Se conseguir inserir um comando na tabela, "res" será maior que 0.
            res = stmt.executeUpdate();
            //Fecha os objetos de manipulação do SGBD.
            stmt.close();
            this.conn.close();    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            res = 0;
        }                
        
        return res;    
    }
    
    /**
     * Método para excluir um curso específico.
     * @param obj 
     * @return  
     */
    public int excluir(Curso obj){
        //Declaração de variável.
        int res = 0;
        //Pega o parâmetro.   
        Long cod = obj.getCodigo();
        //Monta o comando SQL para exclusão.
        String sql = "delete from curso where codigo=?";          
        //Executa.         
        try{         
            PreparedStatement stmt = this.conn.prepareStatement(sql);         
            stmt.setLong(1, cod);
            //Se conseguir inserir um comando na tabela, "res" será maior que 0.
            res = stmt.executeUpdate();
            //Fecha os objetos de manipulação do SGBD.
            stmt.close();
            this.conn.close();    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            res = 0;
        }                
        
        return res;        
    }
}
