package com.wsx.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 19:52.
 * @Modified By:
 */
@Data
@ToString
public class CourseCatalog extends CatalogComponent {

    private List<CatalogComponent> components = new ArrayList<>();

    private String name;
    private Integer level;

    public CourseCatalog() {
    }

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        components.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        components.remove(catalogComponent);
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(name);
        for (CatalogComponent component : components) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
            }
            component.print();
        }
    }
}
