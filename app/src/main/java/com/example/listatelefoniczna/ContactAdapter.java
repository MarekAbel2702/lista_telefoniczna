package com.example.listatelefoniczna;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>
{

    public interface OnDeleteClick
    {
        void onDelete(int position);
    }
    private final List<Contact> contacts;
    private final OnDeleteClick onDeleteClick;

    public ContactAdapter(List<Contact> contacts, OnDeleteClick onDeleteClick)
    {
        this.contacts = contacts;
        this.onDeleteClick = onDeleteClick;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wiersz,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Contact contact = contacts.get(position);
        holder.name.setText(contact.name);
        holder.phone.setText(contact.phone);
        holder.email.setText(contact.email);
        holder.przyciskUsuwanie.setOnClickListener(v -> onDeleteClick.onDelete(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount()
    {
        return contacts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, phone, email;
        Button przyciskUsuwanie;

        ViewHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            email = itemView.findViewById(R.id.email);
            przyciskUsuwanie = itemView.findViewById(R.id.przyciskUsuwanie);
        }
    }
}
