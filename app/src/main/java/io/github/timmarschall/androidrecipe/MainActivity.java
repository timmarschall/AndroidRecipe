package io.github.timmarschall.androidrecipe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//Initializing variables
    private TextView changingTextView;
    private Button heyyyButton;
    private Button hoooButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//implementing the onClickListeners
        changingTextView = (TextView) findViewById(R.id.textView);
        heyyyButton = (Button) findViewById(R.id.heyyy_button);
        heyyyButton.setOnClickListener(this);
        hoooButton = (Button) findViewById(R.id.hooo_button);
        hoooButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) { // Parameter v stands for the view that was clicked.

        // getId() returns the identifier
        if(v.getId() == R.id.heyyy_button){
            // Implement a runnable that changes the text if the user clicks yes
            alertUser("HEYYY", "You down to HEYYYYYYY?",
                    new Runnable() {
                @Override
                public void run() {
                 //What to do if user presses YES
                    changingTextView.setText("HEYYYYYYY!");
                }
                    },
                new Runnable() {
                    @Override
                    public void run() {
                        //What to do if user presses CANCEL
                        changingTextView.setText("You cancelled. Quitter.");
                    }
                });
        }else if(v.getId() == R.id.hooo_button){
            // Implement a runnable that changes the text if the user clicks yes
            alertUser("HOOOO", "You down to HOOOOOO?",
                    new Runnable() {
                        @Override
                        public void run() {
                            //What to do if user presses YES
                            changingTextView.setText("HOOOOOOOO!");
                        }
                    },
                    new Runnable() {
                        @Override
                        public void run() {
                            //What to do is user presses CANCEL
                            changingTextView.setText("You cancelled. Sad Story.");
                        }
                    });
        }
    }

    //This is a generalized method for the AlertDialog. It takes in:
    // A title, a message, a Runnable function which runs in case the user presses yes, a Runnable function which runs in case the user presses no
    public void alertUser (String title,String msg, final Runnable ifTrue, final Runnable ifFalse) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        ifTrue.run();

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ifFalse.run();
                    }
                }).show();
    }
}
