package br.com.unipar.emergencyaid;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.NumberFormat;
public class Begin extends AppCompatActivity {

    public EditText cpf;
    public EditText birthDate;
    public EditText monthlyIncome;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        cpf = findViewById(R.id.cpf);
        birthDate = findViewById(R.id.birthDate);
        monthlyIncome = findViewById(R.id.monthlyIncome);
    }

    public String confirm (View view) {
            User user = new User();
            user.getCpf(cpf.getText().toString());
            user.getBirthDate(birthDate.getText().toString());
            user.getMonthlyIncome(monthlyIncome.getText().toString());
            String errorMessage = ("Acesso Negado.");
            if (user.getAge(user.getBirthDate()) < 18 || user.getMonthlyIncome() > 5000) {
                return errorMessage;
            } else {
                proceed(view, user);
            }
        return null;
    }

    public void proceed (View view, User user) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(3);
        Intent intent = new Intent(this, Begin.class);
        Bundle SS = new Bundle();
        SS.putString("Payday:", String.valueOf(user.getDate(user.getDate())));
        SS.putDouble("Balance:", Double.parseDouble(format.format(user.getBalance(user.getMonthlyIncome()))));
        intent.putExtras(SS);
        startActivity(intent);
    }
}
