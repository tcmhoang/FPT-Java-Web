const operators = ['+', '-', '×', '÷']
class MathQuiz {
    #score
    #currentCorrectAns
    #level

    constructor() {
        this.#score = 0
        this.#level = 1
    }

    genQuestion() {
        const operand = this.#genOperator()
        const o1 = this.#genOperand()
        const o2 = this.#genOperand()
        this.#currentCorrectAns = this.#mathItUp[operand](o1, o2)
        const isPositive = Math.random() > 0.5 ? true : false
        const wAns = this.#getWrongAns(this.#currentCorrectAns, isPositive)
        return {
            equation: `${o1} ${operand} ${o2}`,
            x: !Math.round(Math.random()) ? this.#currentCorrectAns : wAns,
        }
    }

    isRight = (num) => +num == this.#currentCorrectAns

    levelUp = async (seff) => {
        this.#score += 5
        this.#level += 1
        await seff()
    }

    reset = () => {
        this.#score = 0
        this.#level = 1
    }

    get score() {
        return this.#score
    }

    get level() {
        return this.#level
    }

    #getWrongAns = (ta, positive) =>
        Math.floor(positive ? ta + Math.random() * 10 : ta - Math.random() * 10)
    #genOperator = () => operators[Math.floor(Math.random() * operators.length)]

    #genOperand = () => Math.floor(Math.random() * 10 * this.#level) + 1

    #mathItUp = {
        '+': function (x, y) {
            return x + y
        },
        '-': function (x, y) {
            return x - y
        },
        '×': function (x, y) {
            return x * y
        },
        '÷': function (x, y) {
            return (x / y).toFixed(2)
        },
    }
}

export default MathQuiz
