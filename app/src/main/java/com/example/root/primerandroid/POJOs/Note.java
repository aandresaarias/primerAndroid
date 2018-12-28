package com.example.root.primerandroid.POJOs;

public class Note
{
    int id;
    String tittle;
    String body;

    public Note (int id, String tittle, String body)
    {
        this.id = id;
        this.tittle = tittle;
        this.body = body;
    }

    public String getTittle()
    {
        return tittle;
    }

    public void setTittle(String tittle)
    {
        this.tittle = tittle;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
