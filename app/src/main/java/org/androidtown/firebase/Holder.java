package org.androidtown.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class Holder extends RecyclerView.ViewHolder {
  TextView id;
  TextView name;
  TextView email;

  public Holder(View view) {
    super(view);
    id = view.findViewById(R.id.textId);
    name = view.findViewById(R.id.textName);
    email = view.findViewById(R.id.textEmail);
    setIsRecyclable(false);
  }
}
