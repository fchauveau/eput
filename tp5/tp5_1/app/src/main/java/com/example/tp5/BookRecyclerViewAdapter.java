package com.example.tp5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp5.databinding.BookListItemViewBinding;
import com.example.tp5.model.Book;

import java.util.List;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private List<Book> data;

    public BookRecyclerViewAdapter(Context context, List<Book> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BookListItemViewBinding itemViewBinding = BookListItemViewBinding.inflate(LayoutInflater.from(context), parent, false);
        return new BookItemViewHolder(itemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Book currentItem = data.get(position);

        BookItemViewHolder viewHolder = (BookItemViewHolder) holder;
        viewHolder.binding.title.setText(currentItem.title);
        viewHolder.binding.author.setText(currentItem.author);
        viewHolder.binding.editor.setText(currentItem.editor);
        viewHolder.binding.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookFormActivity.class);
                intent.putExtra(BookFormActivity.INTENT_EXTRA_BOOK_TO_EDIT, currentItem);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateBookList(List<Book> allbooks) {
        this.data = allbooks;
        notifyDataSetChanged();
    }


    static class BookItemViewHolder extends RecyclerView.ViewHolder {
        public BookListItemViewBinding binding;

        public BookItemViewHolder(BookListItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
