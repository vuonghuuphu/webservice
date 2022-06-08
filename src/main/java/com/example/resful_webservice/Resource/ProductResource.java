package com.example.resful_webservice.Resource;

import com.example.resful_webservice.Entity.Product;

import javax.ws.rs.*;
import java.util.List;

@Path("/product")
@Produces("application/json")
@Consumes("application/json")
public class ProductResource {

    ProductModel productModel;

    public ProductResource(){
        productModel = new InMemoryProductModel();
    }

    @GET
    public List<Product> productlist() {
        return productModel.findall();
    }

    @GET
    @Path("{id}")
    public Product productdetail(@PathParam("id") int id) {
        return productModel.findbyid(id);
    }

    @POST
    public Product Create (Product product){
        return productModel.save(product);
    }

    @PUT
    @Path("{id}")
    public Product update (@PathParam("id")int id,Product product){
        return productModel.update(product,id);
    }

    @DELETE
    @Path("{id}")
    public boolean update (@PathParam("id")int id){
        return productModel.delete(id);
    }


}