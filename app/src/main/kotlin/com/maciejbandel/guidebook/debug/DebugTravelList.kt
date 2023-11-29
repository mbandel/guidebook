package com.maciejbandel.guidebook.debug

import com.maciejbandel.guidebook.model.Place
import com.maciejbandel.guidebook.model.Travel
import java.time.LocalDate

val debugTravelList: List<Travel> = listOf(
    Travel(
        id = 1,
        name = "barcelona",
        startDate = LocalDate.of(2023, 4, 10),
        endDate = LocalDate.of(2023, 4, 14),
        places = listOf(
            Place(
                name = "sagrada familia",
                date = LocalDate.of(2023, 4, 10),
                visited = true
            ),
            Place(
                name = "guel park",
                date = LocalDate.of(2023, 4, 11)
            ),
            Place(
                "Casa Millo",
                date = LocalDate.of(2023, 4, 11)
            )
        )
    ),
    Travel(
        id = 2,
        name = "Ateny",
        startDate = LocalDate.of(2023, 4, 10),
        endDate = LocalDate.of(2023, 4, 14),
        places = listOf(
            Place(
                name = "Panteon",
                date = LocalDate.of(2023, 4, 10),
                visited = true
            ),
            Place(
                name = "Akropol",
                date = LocalDate.of(2023, 4, 11)
            ),
            Place(
                "muzeum Akropolu",
                date = LocalDate.of(2023, 4, 11)
            )
        )
    ),
    Travel(
        id = 3,
        name = "Lizbona",
        startDate = LocalDate.of(2023, 4, 10),
        endDate = LocalDate.of(2023, 4, 14),
        places = listOf(
            Place(
                name = "morze",
                date = LocalDate.of(2023, 4, 13),
                visited = true
            ),
            Place(
                name = "muzeum",
                date = LocalDate.of(2023, 4, 11)
            ),
            Place(
                name = "wystawa sardynek",
                date = LocalDate.of(2023, 4, 10)
            )
        )
    ),
)