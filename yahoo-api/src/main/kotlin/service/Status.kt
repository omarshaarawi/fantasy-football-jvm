package service

enum class Status {
    A, // (all available players)

    FA, // (free agents only)

    W, // (waivers only)

    T, // (all taken players)

    K, // (keepers only)
}
