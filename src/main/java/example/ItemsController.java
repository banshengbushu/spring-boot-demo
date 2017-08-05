package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ItemsController {
    ArrayList<String> alias = new ArrayList<String>();

    @RequestMapping("/")
    public String index(@RequestParam(value = "str", defaultValue = "Hello World") String str) {
        return "static/index.html";
    }

    @RequestMapping("/handleBars")
    public String handleBars() {
        return "static/handleBars.html";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Items getItem(@RequestParam(value = "id") int id) throws IOException {
        alias.add("a1");
        alias.add("a2");
        alias.add("a3");
        Items items = new Items("apple", 4, 3.0, id, alias);   ////
        return items;
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String saveItems(@RequestBody Items items) {
        this.alias = items.getAlias();
        System.out.println(alias + "Post");

        return "send success";
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    public String updateItem(@PathVariable Integer id, Items newItems)  {
        Items items = new Items("apple", 4, 2.5, 1, new ArrayList());
        if(items.getId() == id){
            items.setPrice(newItems.getPrice());
            items.setName(newItems.getName());
            items.setCount(newItems.getCount());

            System.out.println(items + "Updated items");
            System.out.println(newItems + "Updated newItems");
            return "update id success";        ///response message code
        }
        return "no update";
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public Items deleteItem(@RequestBody Integer id) {
        ArrayList<String> alias = new ArrayList<>();
        alias.add("one");
        alias.add("two");
        alias.add("three");

        Items items = new Items("apple", 4, 2.5, 3, alias);
        if(items.getId() == id){
            for(Object alia  : items.getAlias()){
                System.out.println(alia);
            }
        }

        System.out.println(this.alias + "Post");

        return items;
    }
}
