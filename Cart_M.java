import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cart_M {
    Connection connection;
    Statement stmt;
    int noOfRecords;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = Connectionbase.getInstance().getConnection();
        return con;
    }

    public List<Add_to_cart> viewAllItems(String UserName) {
        String query = "select * from Cart where UserName=\""+UserName+"\";";
        List<Add_to_cart> list = new ArrayList<Add_to_cart>();
        Add_to_cart item = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                item = new Add_to_cart();
                item.setUserName(rs.getString(1));
                item.setItemQuantity(rs.getInt(4));
                item.setItemName(rs.getString(2));
                item.setCategory(rs.getString(6));
                item.setImage(rs.getString(7));
                item.setItemPrice(rs.getInt(3));
                item.setTotalPrice(rs.getInt(5));
                list.add(item);
            }
            rs.close();
            connection.close();
            stmt.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean checkItemInCart(String username, String item_id) {
        String query = "Select count(*) from Cart where username=\"" + username + "\" and Item_Name=\"" + item_id
                + "\";";
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
            rs.close();
            connection.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
   }

    public void updateQty(String username, String item_id, int item_qty) {
        String query = "update Cart set Item_Qty=" + item_qty + " where username=\"" + username + "\" and Item_Name=\""
                + item_id + "\";";
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAllItems(String item_id) {
        String query = "delete from Cart where Item_Name=\"" + item_id + "\";";
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUserItem(String username, String item_id) {
        String query = "delete from Cart where Item_Name=\"" + item_id + "\" and username=\"" + username + "\";";
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void clearCart(String username) {
        String query = "delete from Cart where username=\"" + username + "\";";
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateStock(String item_id, int item_stock) {
        String query = "update Items set Qty=" + item_stock + " where Name=\"" + item_id + "\";";
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public int gettheStock(String Name)
    {
    	String query1 ="select * from Items where Name=\""+Name+"\";";
    	int st=0;
       try {
           connection = getConnection();
           stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(query1);
           if (rs.next()) {
               st=rs.getInt(5);
           }
           rs.close();
           connection.close();
           stmt.close();

       } catch (Exception ex) {
           ex.printStackTrace();
       }
    	
    	return st;
    	
    }
    public void addCartItemsToOrders(String username) {
        List<Add_to_cart> items = viewAllItems(username);
        String query = "insert into orders values(?,?,?,?,?,?,?,?);";

        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            for (var item : items) {
                ps.setString(1, username);
                LocalDate dateObj = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String date = dateObj.format(formatter);
                ps.setString(8, date);
                ps.setInt(5, item.getTotalPrice());
                ps.setInt(4, item.getItemQuantity());
                ps.setString(2,item.getItemName());
                ps.setString(7, item.getImage());
                ps.setString(6, item.getCategory());
                ps.setInt(3, item.getItemPrice());
                ps.execute();
                int oldstock = gettheStock(item.getItemName());
                int newStock = oldstock	-item.getItemQuantity();
                if (newStock == 0) {
                  Method dao=new Method();
                     dao.deleteItem(item.ItemName);
                } else {
                    updateStock(item.ItemName, newStock);
                 }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setNoOfRecords(int a) {
        noOfRecords = a;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

	public List<Table_Order> viewUserOrders(String username) {
        String query = "select * from orders where username=\""+username+"\";";
        List<Table_Order> list = new ArrayList<Table_Order>();
        Table_Order item = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                item = new Table_Order();
                item.setItemQuantity(rs.getInt(4));
                item.setItemName(rs.getString(2));
                item.setCategory(rs.getString(6));
                item.setImage(rs.getString(7));
                item.setItemPrice(rs.getInt(3));
                item.setTotalPrice(rs.getInt(5));
                item.setUserName(username);
                item.setordered_date(rs.getString(8));
                list.add(item);
            }
            rs.close();
            connection.close();
            stmt.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (item == null) {
            return null;
        }
        return list;
    }
	public List<Table_Order> viewAllOrders() {
        String query = "select * from orders;";
        List<Table_Order> list = new ArrayList<Table_Order>();
        Table_Order item = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                item = new Table_Order();
                item.setItemQuantity(rs.getInt(4));
                item.setItemName(rs.getString(2));
                item.setCategory(rs.getString(6));
                item.setImage(rs.getString(7));
                item.setItemPrice(rs.getInt(3));
                item.setTotalPrice(rs.getInt(5));
                item.setUserName(rs.getString(1));
                item.setordered_date(rs.getString(8));
                list.add(item);
            }
            rs.close();
            connection.close();
            stmt.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (item == null) {
            return null;
        }
        return list;
    }
	 public List<Table_Order> viewQueryOrders(String start_date, String end_date) {
	        String query = "select * from orders where Ordered_date between \""+start_date+"\" and \""+end_date+"\";";
	        List<Table_Order> list = new ArrayList<Table_Order>();
	        Table_Order item = null;
	        try {
	            connection = getConnection();
	            stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                item = new Table_Order();
	                item.setItemQuantity(rs.getInt(4));
	                item.setItemName(rs.getString(2));
	                item.setCategory(rs.getString(6));
	                item.setImage(rs.getString(7));
	                item.setItemPrice(rs.getInt(3));
	                item.setTotalPrice(rs.getInt(5));
	                item.setUserName(rs.getString(1));
	                item.setordered_date(rs.getString(8));
	                list.add(item);
	            }
	            rs.close();
	            connection.close();
	            stmt.close();
	            rs.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        if (item == null) {
	            return null;
	        }
	        return list;

	    }
	 public List<Table_Order> viewQueryUserOrders(String start_date) {
	        String query = "select * from orders where UserName = \""+start_date+"\";";
	        List<Table_Order> list = new ArrayList<Table_Order>();
	        Table_Order item = null;
	        try {
	            connection = getConnection();
	            stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                item = new Table_Order();
	                item.setItemQuantity(rs.getInt(4));
	                item.setItemName(rs.getString(2));
	                item.setCategory(rs.getString(6));
	                item.setImage(rs.getString(7));
	                item.setItemPrice(rs.getInt(3));
	                item.setTotalPrice(rs.getInt(5));
	                item.setUserName(rs.getString(1));
	                item.setordered_date(rs.getString(8));
	                list.add(item);
	            }
	            rs.close();
	            connection.close();
	            stmt.close();
	            rs.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        if (item == null) {
	            return null;
	        }
	        return list;

	    }

}
