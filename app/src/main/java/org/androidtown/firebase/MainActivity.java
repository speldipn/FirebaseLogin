package org.androidtown.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  public final String TAG_NAME = "speldipn";

  FirebaseDatabase database;
  DatabaseReference userRef;

  @BindView(R.id.editId)
  EditText editId;

  @BindView(R.id.editName)
  EditText editName;

  @BindView(R.id.editEmail)
  EditText editEmail;

  @BindView(R.id.recyclerView)
  RecyclerView recyclerView;

  List<User> list = new ArrayList<>();
  CustomAdapter customAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    initDB();
    setApdater();
    setEvent();
  }

  public void initDB() {
    // 데이터베이스 연결
    database = FirebaseDatabase.getInstance();
    // 연결할 노드를 설정
    userRef = database.getReference("users");
  }

  public void setApdater() {
    customAdapter = new CustomAdapter();
    customAdapter.setDataAndRefresh(list);
    recyclerView.setAdapter(customAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }

  public void setEvent() {
    userRef.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        list.clear();
        for(DataSnapshot dss : dataSnapshot.getChildren()) {
          User user = dss.getValue(User.class);
          list.add(user);
        }
        customAdapter.setDataAndRefresh(list);
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG_NAME, "onCancelled " + databaseError.getMessage());
      }
    });
  }


  private void writeNewUser(String userId, String name, String email) {
    User user = new User(userId, name, email);
    userRef.child(userId).setValue(user);
    userRef.push();
  }

  public void addUser(View v) {
    String id = editId.getText().toString();
    String name = editName.getText().toString();
    String email = editEmail.getText().toString();
    writeNewUser(id, name, email);
  }

} // end of class
