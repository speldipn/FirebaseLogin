package org.androidtown.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Holder extends RecyclerView.ViewHolder {
  @BindView(R.id.textId)
  TextView id;
  @BindView(R.id.textName)
  TextView name;
  @BindView(R.id.textEmail)
  TextView email;

  public Holder(View view) {
    super(view); // TODO: 반드시 필요한 요소인지 확인
    ButterKnife.bind(view);
  }
}
