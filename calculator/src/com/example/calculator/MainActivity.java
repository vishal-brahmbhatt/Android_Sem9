package com.example.calculator;

import java.util.Stack;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

class EvaluateString {
	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();


		Stack<Integer> values = new Stack<Integer>();


		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i] == ' ')
				continue;


			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();

				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}


			else if (tokens[i] == '(')
				ops.push(tokens[i]);


			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.push(tokens[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));


		return values.pop();
	}

	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

}

public class MainActivity extends Activity {

	Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd,
			buttonSub, buttonDiv, buttonMul, buttonC, buttonEqu, buttonOpenb, buttonCloseb;

	EditText digitEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button0 = (Button) findViewById(R.id.button0);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		button7 = (Button) findViewById(R.id.button7);
		button8 = (Button) findViewById(R.id.button8);
		button9 = (Button) findViewById(R.id.button9);
		buttonAdd = (Button) findViewById(R.id.buttonplus);
		buttonSub = (Button) findViewById(R.id.buttonsub);
		buttonDiv = (Button) findViewById(R.id.buttondiv);
		buttonMul = (Button) findViewById(R.id.buttonmul);
		buttonC = (Button) findViewById(R.id.buttonC);
		buttonEqu = (Button) findViewById(R.id.buttonequ);
		buttonOpenb = (Button) findViewById(R.id.buttonopenb);
		buttonCloseb = (Button) findViewById(R.id.buttoncloseb);
		digitEditText = (EditText) findViewById(R.id.editText1);

		button0.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "0");
			}
		});

		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "1");
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "2");
			}
		});

		button3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "3");
			}
		});

		button4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "4");
			}
		});

		button5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "5");
			}
		});

		button6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "6");
			}
		});

		button7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "7");
			}
		});

		button8.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "8");
			}
		});

		button9.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + "9");
			}
		});

		buttonAdd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + " + ");
			}
		});

		buttonSub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + " - ");
			}
		});

		buttonDiv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + " / ");
			}
		});

		buttonMul.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + " * ");
			}
		});

		buttonOpenb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + " ( ");
			}
		});
		
		buttonCloseb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText(digitEditText.getText() + " ) ");
			}
		});

		buttonC.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				digitEditText.setText("");
			}
		});

		buttonEqu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String equation =  digitEditText.getText().toString();
				int ans = EvaluateString.evaluate(equation);
				digitEditText.setText(Integer.toString(ans));
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
