package com.mapbox.rctmgl.components.styles.light;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.style.layers.TransitionOptions;
import com.mapbox.mapboxsdk.style.light.Light;
import com.mapbox.mapboxsdk.style.light.Position;
import com.mapbox.rctmgl.components.AbstractMapFeature;
import com.mapbox.rctmgl.components.mapview.RCTMGLMapView;
import com.mapbox.rctmgl.components.styles.RCTMGLStyle;
import com.mapbox.rctmgl.components.styles.RCTMGLStyleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickitaliano on 9/26/17.
 */

public class RCTMGLLight extends AbstractMapFeature {
    private MapboxMap mMap;
    private ReadableMap mReactStyle;

    public RCTMGLLight(Context context) {
        super(context);
    }

    @Override
    public void addToMap(RCTMGLMapView mapView) {
        mMap = mapView.getMapboxMap();
        setLight(mMap.getLight());
    }

    @Override
    public void removeFromMap(RCTMGLMapView mapView) {
        // ignore there's nothing to remove just update the light style
    }

    public void setReactStyle(ReadableMap reactStyle) {
        mReactStyle = reactStyle;

        if (mMap != null) {
            setLight(mMap.getLight());
        }
    }

    private void setLight(Light light) {
        RCTMGLStyleFactory.setLightLayerStyle(light, new RCTMGLStyle(mReactStyle, mMap));
    }
}
