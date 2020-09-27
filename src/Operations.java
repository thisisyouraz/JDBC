import java.sql.*;
public class Operations {

    String url = "jdbc:mysql://localhost:3306/jbdc";
    String user = "root";
    String pass = "12345678";
    Connection conn;
    public void connectWithDB() {
        // DriverManager class used to establish a connection with the server via getConnection method.
        // Statement interface is used to execute query .
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String userName){
        String query="delete from user where user_name=?";
        try {
            PreparedStatement pr_stmt = conn.prepareStatement(query);
            pr_stmt.setString(1,userName);
            int count=pr_stmt.executeUpdate();


            if(count==0){
                System.out.println("No such user found :)");
            }
            else if(count>0){
                System.out.println("user deleted successfully!");
                select();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void select(){
        try {
            String query="SELECT * FROM USER";
            Statement stmt = conn.createStatement();

            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                System.out.print("user= " +rs.getString("user_name"));
                System.out.println("    pass= "+rs.getString("password"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(String user,String pass){
        String query="INSERT into user(user_name,password) values(?,?)";
        try {
            PreparedStatement pr_stmt = conn.prepareStatement(query);
            pr_stmt.setString(1, user);
            pr_stmt.setString(2,pass);

            int count=pr_stmt.executeUpdate();
            if(count>0){
                System.out.println(count+"row effected");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(String newPass, String user){
        String query="UPDATE USER SET PASSWORD=? where user_name=?";
        try {
            PreparedStatement pr_stmt = conn.prepareStatement(query);
            pr_stmt.setString(1,newPass);
            pr_stmt.setString(2,user);

            int count=pr_stmt.executeUpdate();

            if(count==0){
                System.out.println("No such user found :)");
            }
            else if(count>0){
                System.out.println("password updated successfully!");
                select();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
