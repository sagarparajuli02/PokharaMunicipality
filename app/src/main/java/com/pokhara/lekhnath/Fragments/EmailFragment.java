package com.pokhara.lekhnath.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pokhara.lekhnath.R;

public class EmailFragment extends Fragment {


    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_email, container, false);


        final EditText your_name =  view.findViewById(R.id.name);
        final EditText your_phone = view.findViewById(R.id.phone);
        final EditText your_citizenship = view.findViewById(R.id.citizenship);
        final EditText your_comments = view.findViewById(R.id.comments);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = your_name.getText().toString();
                String phone = your_phone.getText().toString();
                String citizenship = your_citizenship.getText().toString();
                String comments = your_comments.getText().toString();

                if (TextUtils.isEmpty(name)){
                    your_name.setError("Please enter your name");
                    your_name.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    your_phone.setError("Enter your number");
                    your_phone.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(citizenship)){
                    your_citizenship.setError("Enter your citizenship number");
                    your_citizenship.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(comments)){
                    your_comments.setError("Please enter your message");
                    your_comments.requestFocus();
                    return;
                }

                String[] TO = {
                        "mayor@pokharamun.gov.np"
                };

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from Mobile App");
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        "Name: " + name + '\n' +
                                "Phone Number: " + phone + '\n' +
                                "Citizenship Number: " + citizenship + '\n' +
                                "Message: " + comments   );

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
