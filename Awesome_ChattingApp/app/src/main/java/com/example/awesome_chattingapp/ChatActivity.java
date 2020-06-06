package com.example.awesome_chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    EditText chatEditText;
    Button sendButton;
    String nickname;
    FirebaseDatabase database;
    private static final String TAG = "ChatActivity";
    ArrayList<Chat> chatArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatArrayList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        recyclerView = (RecyclerView) findViewById(R.id.chatReclyclerView);
        chatEditText = (EditText) findViewById(R.id.chatEditText);
        sendButton = (Button) findViewById(R.id.sendButton);
        nickname = getIntent().getStringExtra("nickname");

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(false);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(chatArrayList, nickname);
        recyclerView.setAdapter(mAdapter);

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                Chat chat = dataSnapshot.getValue(Chat.class);
                String chatNickname = chat.getNickname();
                String chatMessage = chat.getMessage();
                Log.d(TAG, "chatNickname: " + chatNickname);
                Log.d(TAG, "chatMessage: " + chatMessage);
                chatArrayList.add(chat);
                recyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
                mAdapter.notifyDataSetChanged();
                // ...
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                Chat newChat = dataSnapshot.getValue(Chat.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String chatKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                Chat movedChat = dataSnapshot.getValue(Chat.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
                Toast.makeText(ChatActivity.this, "Failed to load comments.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        DatabaseReference ref = database.getReference("messages");
        ref.addChildEventListener(childEventListener);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendText = chatEditText.getText().toString();
                if(sendText.replaceAll(" " , "").replaceAll("\\p{Z}", "").replaceAll("\n","").equals("")) {
                    return;
                }
                // Write a message to the database

                long now = System.currentTimeMillis();
                // 현재시간을 date 변수에 저장한다.
                Date date = new Date(now);
                // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
                SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // nowDate 변수에 값을 저장한다.
                String formatDate = sdfNow.format(date);

                DatabaseReference myRef = database.getReference("messages").child(formatDate);

                Hashtable<String, String> messages = new Hashtable<String, String>();
                messages.put("nickname", nickname);
                messages.put("message", sendText);
                myRef.setValue(messages);
                chatEditText.setText("");
            }
        });
    }
    // ...
}
