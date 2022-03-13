const DEFAULT_TIMEOUT = 20_000
const MIN_TIMEOUT = 5_000

class ElaspedTime {
    #isStop
    #currentTimer

    constructor() {
        this.#isStop = false
    }

    async #startTimer(duration, seffs = (val) => {}, timeout = () => {}) {
        const firstTen = duration / 10
        this.#isStop = false

        for (let i = 0; i <= 10; i++) {
            if (this.#isStop) break
            seffs(i * 10)
            await new Promise(
                (rs) => (this.#currentTimer = setTimeout(rs, firstTen))
            )
        }
        if (!this.#isStop) {
            timeout()
        }
    }

    get currentTimer() {
        return this.#currentTimer
    }

    async start(level, seffs, timeout) {
        this.#startTimer(
            DEFAULT_TIMEOUT / level > MIN_TIMEOUT
                ? DEFAULT_TIMEOUT / level
                : MIN_TIMEOUT,
            seffs,
            timeout
        )
    }

    stop() {
        this.#isStop = true
        clearTimeout(this.#currentTimer)
    }
}

export default ElaspedTime
