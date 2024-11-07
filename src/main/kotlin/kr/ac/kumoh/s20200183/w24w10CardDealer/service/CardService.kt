package kr.ac.kumoh.s20200183.w24w10CardDealer.service

import kr.ac.kumoh.s20200183.w24w10CardDealer.repository.CardRepository
import org.springframework.stereotype.Service
import kr.ac.kumoh.s20200183.w24w10CardDealer.model.Card
import kotlin.random.Random

@Service
class CardService(private val repository: CardRepository) {
    fun getAllCards(): List<Card> {
        return repository.getAllCards()
    }

    fun dealCards(count: Int = 5) {
        val suits = arrayOf("clubs", "diamonds", "hearts", "spades")
        val ranks = arrayOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace")

        repository.clear()

        val uniqueCards = mutableSetOf<Card>()
        while (uniqueCards.size < count) {
            val randomSuit = suits[Random.nextInt(suits.size)]
            val randomRank = ranks[Random.nextInt(ranks.size)]
            uniqueCards.add(Card(randomRank, randomSuit))
        }

        val sortedCards = uniqueCards.toList()
            .sortedWith(compareBy({ suits.indexOf(it.suit) }, { ranks.indexOf(it.rank) }))

        sortedCards.forEach { repository.add(it) }
    }
}