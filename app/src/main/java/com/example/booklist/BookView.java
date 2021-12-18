package com.example.booklist;

public class BookView {
    private int idBookImage;
    private String TitleID;
    private String BookName;
    private String Category;
    private int Pages;
    private String Sales;

    public BookView(int idBookImage, String TitleID, String BookName, String Category, int Pages, String Sales){
        this.idBookImage = idBookImage;
        this.TitleID = TitleID;
        this.BookName = BookName;
        this.Category = Category;
        this.Pages = Pages;
        this.Sales = Sales;
    }

    public int getIdBookImage() { return idBookImage; }

    public String getTitleID(){ return TitleID; }

    public String getBookName() { return BookName; }

    public String getCategory() { return Category; }

    public int getPages() { return Pages; }

    public String getSales() { return Sales; }
}
