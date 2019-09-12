package xyz.mystiko.ar;

import com.google.ar.sceneform.ux.ArFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ar.core.Config;
import com.google.ar.core.Config.AugmentedFaceMode;
import com.google.ar.core.Session;
import java.util.EnumSet;
import java.util.Set;

public class FaceArFragment extends ArFragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout frameLayout =
                (FrameLayout) super.onCreateView(inflater, container, savedInstanceState);


        getPlaneDiscoveryController().hide();
        getPlaneDiscoveryController().setInstructionView(null);

        return frameLayout;
    }

    @Override
    protected Set<Session.Feature> getSessionFeatures() {
        return EnumSet.of(Session.Feature.FRONT_CAMERA);
    }

    @Override
    protected Config getSessionConfiguration(Session session) {
        Config config = new Config(session);
        // Configure 3D Face Mesh
        config.setAugmentedFaceMode(AugmentedFaceMode.MESH3D);
        return config;
    }
}
