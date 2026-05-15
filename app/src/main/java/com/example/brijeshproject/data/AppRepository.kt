package com.example.brijeshproject.data

import com.example.brijeshproject.model.Saree
import com.example.brijeshproject.model.SareeType
import com.example.brijeshproject.model.Trend
import com.example.brijeshproject.model.Weaver

object AppRepository {
    val weavers = listOf(
        Weaver("1", "Basavaraj", "Ilkal", 25, "https://example.com/weaver1.jpg", "Expert in Ilkal Gomi border sarees.", "9876543210", 4.8f),
        Weaver("2", "Lakshmi", "Molakalmuru", 15, "https://example.com/weaver2.jpg", "Specialist in temple border designs.", "9876543211", 4.9f),
    )

    val sarees = listOf(
        Saree("101", "Classic Ilkal Gomi", "Traditional Ilkal saree with red border.", 4500.0, "https://example.com/saree1.jpg", "1", SareeType.ILKAL, listOf("Red", "Blue"), "Silk-Cotton Mix", 4.7f, 120),
        Saree("102", "Molakalmuru Silk", "Exquisite hand-woven silk saree.", 12000.0, "https://example.com/saree2.jpg", "2", SareeType.MOLAKALMURU, listOf("Yellow", "Green"), "Pure Silk", 4.9f, 85)
    )

    val trends = listOf(
        Trend("t1", "Pastel Revival", "Soft pastel shades are high in demand for weddings.", listOf("Lavender", "Mint Green", "Peach"), "https://example.com/trend1.jpg", "Summer 2024"),
        Trend("t2", "Grey Elegance", "Modern grey tones with silver zari.", listOf("Charcoal", "Silver", "Steel Grey"), "https://example.com/trend2.jpg", "Monsoon 2024")
    )
}
