package kr.ac.kumoh.s20200183.w24w10CardDealer.repository

import org.springframework.stereotype.Repository
import kr.ac.kumoh.s20200183.w24w10CardDealer.model.Card


@Repository
class InMemoryCardRepository : CardRepository {
    private val cards: MutableList<Card> = mutableListOf()

    override val size: Int
        get() = cards.size

    override fun add(card: Card) {
        if(!cards.contains(card)) {
            cards.add(card)
        }
    }

    override fun getAllCards(): List<Card> {
        return cards
    }

    override fun clear() {
        cards.clear()
    }
}