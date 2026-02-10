package com.example.listatelefoniczna;

import java.util.ArrayList;
import java.util.List;

public class Wszystkie_Kontakty
{
    private static final List<Contact> contacts = new ArrayList<>();
    public static List<Contact> getAll()
    {
        return contacts;
    }

    public static void add(Contact c)
    {
        contacts.add(c);
    }

    public static void remove(int position)
    {
        if (position >= 0 && position < contacts.size())
        {
            contacts.remove(position);
        }
    }
}
