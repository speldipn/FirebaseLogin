package org.androidtown.firebase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;

public class CustomAdapter extends RecyclerView.Adapter<Holder> {
  List<User> list;

  public void setDataAndRefresh(List list) {
    this.list = list;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new Holder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    User user = list.get(position);
    holder.id.setText(user.id);
    holder.name.setText(user.username);
    holder.email.setText(user.email);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }
} // end of class
