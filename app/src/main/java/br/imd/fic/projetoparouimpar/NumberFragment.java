package br.imd.fic.projetoparouimpar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment implements View.OnClickListener {

    private EditText editNumber;
    private Button btnResult;

    private OnParImparListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(!(context instanceof OnParImparListener)) {
            throw new RuntimeException("Não é um OnParImparListener");
        }

        listener = (OnParImparListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_number, container, false);

        editNumber = view.findViewById(R.id.edit_number);
        btnResult = view.findViewById(R.id.btn_result);

        btnResult.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(listener != null) {
            int number = Integer.parseInt(editNumber.getText().toString());
            listener.onParImpar(number);
        }
    }

    public interface OnParImparListener {
        void onParImpar(int number);
    }
}
