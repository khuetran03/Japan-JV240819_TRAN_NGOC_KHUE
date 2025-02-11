package ra.com.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Prod_id")
    private int prod_id;

    @Column(name = "Prod_name", nullable = false, unique = true, length = 100)
    private String prod_name;

    @Column(name = "Prod_price", nullable = false, unique = true)
    private double prod_price;

    @ManyToOne
    @JoinColumn(name = "Category_id", nullable = false)
    private Category category;

    @Column(name = "Prod_image", columnDefinition = "text")
    private String prod_image;

    @Column(name = "Prod_status", nullable = false, columnDefinition = "bit defautl 1")
    private boolean prod_status;

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public double getProd_price() {
        return prod_price;
    }

    public void setProd_price(double prod_price) {
        this.prod_price = prod_price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProd_image() {
        return prod_image;
    }

    public void setProd_image(String prod_image) {
        this.prod_image = prod_image;
    }

    public boolean isProd_status() {
        return prod_status;
    }

    public void setProd_status(boolean prod_status) {
        this.prod_status = prod_status;
    }
}
