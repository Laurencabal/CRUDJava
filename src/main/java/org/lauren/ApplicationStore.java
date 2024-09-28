package org.lauren;

import lombok.Locked;
import org.lauren.dto.DeleteItem;
import org.lauren.dto.SetItem;
import org.lauren.dto.GetItem;
import org.lauren.dto.Store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//************Elaborado por Lauren Caballero***********//
//*************** Y por Michael Alfonso **************//

@SpringBootApplication
@RestController
public class ApplicationStore {

    private ArrayList<String> sales = new ArrayList<String>();

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStore.class, args);
    }

    public ApplicationStore() {
        sales.add("Chaquetas");
        sales.add("Zapatos");
        sales.add("Pantalones");
        sales.add("Faldas");
        sales.add("Medias");
        sales.add("Sandalias");
        sales.add("Sombreros");
        sales.add("Gafas");
        sales.add("Guantes");
    }

    @GetMapping("/hello")
    public String helloWorld(String[] args) {
        return "Hello, World!";
    }

    //Lectura de datos por id
    @GetMapping("/store/{id}")
    public GetItem setItems(@PathVariable String id) {
        try {
            return new GetItem(sales.get(Integer.parseInt(id)));
        } catch (Exception e) {
            return new GetItem("No existe");
        }
    }

    @DeleteMapping("/store/{idDelete}")
    public DeleteItem deleteItems(@PathVariable String idDelete){
        try{
            return new DeleteItem(sales.remove(Integer.parseInt(idDelete)));
        } catch (Exception e){
            return new DeleteItem("Ya fue eliminado");
        }
    }

    //Lectura de datos por valores
    @GetMapping("/sales")
    public ArrayList<String> getItems(String[] args) {
        return sales;
    }

    @PostMapping("/sales")
    public SetItem setItems(@RequestBody Store store) {
        sales.add(store.getName());
        return new SetItem();
    }

    @PutMapping("/sales/{id}")
    public SetItem createUser(@PathVariable String id, @RequestBody Store store){
        sales.set(Integer.parseInt(id), store.getName());
        return new SetItem();
    }
}