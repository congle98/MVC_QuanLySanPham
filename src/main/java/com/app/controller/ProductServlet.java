package com.app.controller;

import com.app.models.Product;
import com.app.service.ProductService;
import com.app.service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new  ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if (action == null){
           action = "";
       }
       switch (action){
           case "create":
               showCreateForm(req,resp);
               break;
           case "edit":
               showEditForm(req,resp);
               break;
           case "delete":
               showDeleteForm(req,resp);
               break;
           case "view":
               viewProduct(req,resp);
               break;
           default:
               listProducts(req,resp);
               break;
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "delete":
                deleteCustomer(req,resp);
                break;
            case "edit":
                updateCustomer(req,resp);
                break;
            default:
                break;
        }



    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findALL();
        req.setAttribute("products",products);
        RequestDispatcher rd = req.getRequestDispatcher("/product/list.jsp");
        try {
            rd.forward(req,resp);
        }
        catch (ServletException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String classify = request.getParameter("classify");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        int id = (int)(Math.random() * 10000);

        Product product = new Product(id, name, classify, price,describe);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher rd;
        if(product!=null){
            productService.remove(id);
            try {
                response.sendRedirect("/products");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            rd = request.getRequestDispatcher("error-404.jsp");

        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String classify = request.getParameter("classify");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        Product product = productService.findById(id);
        RequestDispatcher rd;
        if(product!=null){
            product.setName(name);
            product.setClassify(classify);
            product.setDescribe(describe);
            product.setPrice(price);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            rd = request.getRequestDispatcher("product/edit.jsp");
        }
        else {
            rd = request.getRequestDispatcher("error-404.jsp");
        }
        try {
            rd.forward(request,response);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher rd;
        if(product!=null){
            request.setAttribute("product",product);
            rd= request.getRequestDispatcher("/product/view.jsp");
        }
        else {
            rd= request.getRequestDispatcher("error-404.jsp");
        }
        try {
            rd.forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
