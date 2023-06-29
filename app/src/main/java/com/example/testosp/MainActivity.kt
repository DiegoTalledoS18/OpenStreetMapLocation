package com.example.testosp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configuración de OpenStreetMap
        val context = applicationContext
        Configuration.getInstance().load(context, getPreferences(MODE_PRIVATE))

        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.mapView)

        // Configuración del mapa
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        mapView.setMultiTouchControls(true)

        // Ubicaciones por latitud y longitud
        val location1 = GeoPoint(-12.0791137, -77.0947866) // Ejemplo: San miguel
        val location2 = GeoPoint(-12.121498, -77.0259064) // Ejemplo: Miraflores

        // Mostrar ubicaciones en el mapa
        mapView.controller.setZoom(15.0)
        mapView.controller.setCenter(location1)

        // Agregar marcadores para las ubicaciones
        val marker1 = Marker(mapView)
        marker1.position = location1
        marker1.title = "Ubicación 1"
        mapView.overlays.add(marker1)

        val marker2 = Marker(mapView)
        marker2.position = location2
        marker2.title = "Ubicación 2"
        mapView.overlays.add(marker2)


    }
}