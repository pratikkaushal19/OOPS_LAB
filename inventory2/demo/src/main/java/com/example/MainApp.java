package com.example;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.util.List;

public class MainApp extends Application {

    private TableView<Product> table = new TableView<>();
    private ObservableList<Product> productList = FXCollections.observableArrayList();
    private TextField nameField = new TextField();
    private TextField descriptionField = new TextField();
    private TextField quantityField = new TextField();
    private TextField priceField = new TextField();
    private TextField searchField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Table setup
        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());

        TableColumn<Product, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());

        TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty().asObject());

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());

        table.getColumns().addAll(nameCol, descriptionCol, quantityCol, priceCol);
        table.setItems(productList);

        // Input fields
        nameField.setPromptText("Product Name");
        descriptionField.setPromptText("Description");
        quantityField.setPromptText("Quantity");
        priceField.setPromptText("Price");

        // Search Field
        searchField.setPromptText("Search Products");
        searchField.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> filterProducts());

        // Buttons
        Button addButton = new Button("Add Product");
        addButton.setOnAction(e -> addProduct());

        Button updateButton = new Button("Update Product");
        updateButton.setOnAction(e -> updateProduct());

        Button deleteButton = new Button("Delete Product");
        deleteButton.setOnAction(e -> deleteProduct());

        // Layout
        HBox inputLayout = new HBox(10);
        inputLayout.getChildren().addAll(nameField, descriptionField, quantityField, priceField, addButton);

        HBox controlLayout = new HBox(10);
        controlLayout.getChildren().addAll(updateButton, deleteButton, searchField);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputLayout, controlLayout, table);

        Scene scene = new Scene(layout, 700, 400);
        scene.getStylesheets().add("style.css"); // Add custom CSS for styling
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Load data
        loadProducts();
    }

    private void loadProducts() {
        try {
            List<Product> products = ProductDAO.getAllProducts();
            productList.setAll(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addProduct() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());

        Product product = new Product(0, name, description, quantity, price);
        try {
            ProductDAO.addProduct(product);
            loadProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct() {
        Product selectedProduct = table.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            String name = nameField.getText();
            String description = descriptionField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            selectedProduct.setName(name);
            selectedProduct.setDescription(description);
            selectedProduct.setQuantity(quantity);
            selectedProduct.setPrice(price);

            try {
                ProductDAO.updateProduct(selectedProduct);
                loadProducts();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteProduct() {
        Product selectedProduct = table.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                ProductDAO.deleteProduct(selectedProduct.getId());
                loadProducts();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void filterProducts() {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<Product> filteredList = FXCollections.observableArrayList();
        
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(searchText)) {
                filteredList.add(product);
            }
        }
        table.setItems(filteredList);
    }
}
