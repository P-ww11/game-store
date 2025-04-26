public final class Product {
    private static final int MAX_QUANTITY = 1000; 
    private static final double MAX_PRICE = 10_000.00;

    private final UUID id;
    private final String name; 
    private final String description; 
    private final double price;
    private final int quantity;
    private final Category category;
    private final String imgUrl;
    private final ReleaseDate releaseDate;
    private final Discount discount;

    private Product(final @NotNull UUID id,final @NotNull String name,final @NotNull String description,final @NotNull double price,final @NotNull int quantity,final @NotNull Category,final @NotNull category,final @NotNull String imgUrl,final @NotNull ReleaseDate releaseDate,final @NotNull Discount discount){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.imgUrl = imgUrl;
        this.releaseDate = releaseDate;
        this.discount = discount;
    }

    private static Product of(final String id, final String name,final String description,final double price,final int quantity,final Category,final category,final String imgUrl,final ReleaseDate releaseDate,final Discount discount){
        UUID newId;
        try {
            newId = (id == null || id.isBlank()) ? UUID.randomUUID() : UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidProductException("PRODUCT_ID_ERROR", "Provided ID is not a valid UUID.");
        }
        if(name == null || name.isBlank()){
            throw new InvalidUserException("PRODUCT_NAME_ERROR", "Name cannot be null or empty.");
        }
        if (description == null || description.isBlank()) {
            throw new InvalidUserException("PRODUCT_DESCRIPTION_ERROR", "Description cannot be null or empty.");
        }
        if(price <= 0 || price > MAX_PRICE){
            throw new InvalidProductException("PRODUCT_PRICE_ERROR", "Product price must be a positive value greater than zero and cannot exceed " + MAX_PRICE + ". Provided price: " + price);
        }
         if (quantity < 0 || quantity > MAX_QUANTITY) {
            throw new InvalidProductException("PRODUCT_QUANTITY_ERROR","Product quantity must be a positive number and cannot exceed " + MAX_QUANTITY + " units. Provided quantity: " + quantity);
        }
        if (imgUrl == null || imgUrl.isBlank()) {
            throw new InvalidUserException("PRODUCT_IMG_URL_ERROR", "image Url cannot be null or empty.");
        }
        return new Product(newId, name, description, price, quantity,category,imgUrl,releaseDate,discount);
        
    }
     public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public Discount getDiscount() {
        return discount;
    }

}