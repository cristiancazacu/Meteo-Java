package ro.mta.se.lab.image;

import animatefx.animation.*;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;


//Wrapper pentru AnimateFX si intermediar

//Mergea si o varianta cu o singura functie, 2 parametrii unul Nod si unul String effect si un switch case da mi-a venit ideea mai tarziu
public class EffectsHandler {
    Node UIObject;

    Pulse pulse;
    FadeIn fadeIn;
    RotateInUpLeft rotateInUpLeft;
    RubberBand rubberBand;
    Flash flash;
    Swing swing;
    Jello jello;
    Bounce bounce;
    BounceIn bounceIn;
    LightSpeedIn lightSpeedIn;


    public  EffectsHandler(Node UI)
    {
        this.UIObject = UI;
        pulse = new Pulse(UIObject);
        fadeIn = new FadeIn(UIObject);
        rotateInUpLeft = new RotateInUpLeft(UIObject);
        rubberBand = new RubberBand(UIObject);
        flash = new Flash(UIObject);
        swing = new Swing(UIObject);
        jello = new Jello(UIObject);
        bounce = new Bounce(UIObject);
        bounceIn = new BounceIn(UIObject);
        lightSpeedIn = new LightSpeedIn(UI);
    }


    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayPulseEffect()
    {
        if (pulse != null)
        {
            pulse.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayPulseEffect(Node UI)
    {
       new Pulse(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayFadeInEffect()
    {
        if (fadeIn != null)
        {
            fadeIn.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayFadeInEffect(Node UI)
    {
        new FadeIn(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayRotateInUpLeftEffect()
    {
        if (rotateInUpLeft != null)
        {
            rotateInUpLeft.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayRotateInUpLeftEffect(Node UI)
    {
        new RotateInUpLeft(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayRubberBandEffect()
    {
        if (rubberBand != null)
        {
            rubberBand.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayRubberBandEffect(Node UI)
    {
        new RubberBand(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayFlashEffect()
    {
        if (flash != null)
        {
            flash.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayFlashEffect(Node UI)
    {
        new Flash(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlaySwingEffect()
    {
        if (swing != null)
        {
            swing.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlaySwingEffect(Node UI)
    {
        new Swing(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayJelloEffect()
    {
        if (jello != null)
        {
            jello.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayJelloEffect(Node UI)
    {
        new Jello(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayBounceEffect()
    {
        if (bounce != null)
        {
            bounce.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayBounceEffect(Node UI)
    {
        new Bounce(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayBounceInEffect()
    {
        if (bounceIn != null)
        {
            bounceIn.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayBounceInEffect(Node UI)
    {
        new BounceIn(UI).play();
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     */
    public void PlayLightSpeedInEffect()
    {
        if (lightSpeedIn != null)
        {
            lightSpeedIn.play();
        }
    }

    /**
     * Function plays animation from AnimateFX for the current Node Uer Interface
     *
     * @param UI the Node UIObject used to play animation.
     */
    public static void PlayLightSpeedInEffect(Node UI)
    {
        new LightSpeedIn(UI).play();
    }


    public static void PlayImageRotationTranslate(ImageView UI, double duration, int startAngle, int endAngle, boolean autoReverse, int cycleCount)
    {

        ImageView iv = UI;
        UI.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration),iv);
            rotateTransition.setCycleCount(cycleCount);
            rotateTransition.setAutoReverse(autoReverse);


            if (newValue) {
                rotateTransition.setFromAngle(startAngle);
                rotateTransition.setToAngle(endAngle);
                rotateTransition.play();

                Lighting lighting = new Lighting();
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(45,45,Color.BLACK));

                iv.setEffect(lighting);

            } else {
                rotateTransition.setFromAngle(endAngle);
                rotateTransition.setToAngle(startAngle);
                rotateTransition.play();

                iv.setEffect(null);
            }
        });
    }

    //to do non-static PlayImageRotationTranslate



    public static void PlayImageButtonSelected(ImageView UI)
    {
        ImageView iv = UI;
        UI.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            if (newValue) {
                Lighting lighting = new Lighting();
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(45,45,Color.BLACK));

                iv.setEffect(lighting);

            } else {
                iv.setEffect(null);
            }
        });
    }

    //to do non-static PlayImageButtonSelected

    //to rectify code logic



}
