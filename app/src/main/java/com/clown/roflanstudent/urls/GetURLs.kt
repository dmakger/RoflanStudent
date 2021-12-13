package com.clown.roflanstudent.urls

class GetURLs {
    val urls: Map<String, URLs> = getURLs()

    private fun getURLs(): Map<String, URLs> {
        val vasya = URLs(
            "https://api.npoint.io/401af30e1924c4f24fce",
            "https://api.npoint.io/9d13a41ec9de611954f9"
        )
        val oleg = URLs(
            "https://api.npoint.io/420bd5db253bac7eaffb",
            "https://api.npoint.io/cdc9352ac39eff98506b"
        )

        val urls = mutableMapOf<String, URLs>()
        urls["vasya"] = vasya
        urls["oleg"] = oleg
        return urls
    }
}