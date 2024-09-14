package cl.bootcamp.sprint_m4;

import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cl.bootcamp.sprint_m4.databinding.ActivityVideoKittysBinding;

public class VideoKittysActivity extends AppCompatActivity {
    private ActivityVideoKittysBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityVideoKittysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Carga el VideoFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.video_fragment_container, new VideoFragment())
                    .commit();
        }

        // Configura el botón de volver para regresar a la actividad anterior
        binding.buttonBack.setOnClickListener(v -> {
            // Aquí puedes agregar lógica adicional si es necesario
            finish(); // Finaliza la actividad y vuelve a la anterior
        });

        ViewCompat.setOnApplyWindowInsetsListener(binding.videoFragmentContainer, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}