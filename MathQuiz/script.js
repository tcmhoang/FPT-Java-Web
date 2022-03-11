import ElaspedTime from './ElaspedTime.js'
import MathQuiz from './MathQuiz.js'

document.addEventListener('DOMContentLoaded', function (event) {
    var playGame = false
    const elaspedPanel = document.querySelector('.elasped_time')
    const questionPanel = document.querySelector('.question')
    const ansPanel = document.querySelector('.ans_display')
    const inputPanel = document.querySelector('.ans_input')
    const title = document.querySelector('.title')
    const scoreSpn = document.querySelector('.score')
    const lvlSpn = document.querySelector('.level')
    const timeManager = new ElaspedTime()
    const quizManager = new MathQuiz()
    const updateElaspedTime = (val) => (elaspedPanel.style['width'] = `${val}%`)

    const scoreText = (val) => `Score: ${val}`
    const levelText = (val) => `Level: ${val}`

    const endGame = () => {
        alert(
            `Your score is: ${quizManager.score}. Click on the title to play again!`
        )
        timeManager.stop()
        quizManager.reset()
        scoreSpn.innerHTML = scoreText(0)
        lvlSpn.innerHTML = levelText(1)
        questionPanel.innerHTML = ''
        ansPanel.innerHTML = ''
        playGame = false
        updateElaspedTime(0)
    }

    const refreshLvlAndScore = async () => {
        scoreSpn.innerHTML = scoreText(quizManager.score)
        lvlSpn.innerHTML = levelText(quizManager.level)
        timeManager.stop()
        await newQuest()
    }

    const newQuest = async () => {
        const { equation, x } = quizManager.genQuestion()
        questionPanel.innerHTML = equation
        ansPanel.innerHTML = x
        await timeManager.start(quizManager.level, updateElaspedTime, endGame)
    }

    title.addEventListener('click', async (e) => {
        if (!playGame) {
            playGame = confirm('Are you sure to start the game?')
                ? newQuest()
                : () => {}
        }

        e.stopPropagation()
    })

    inputPanel.addEventListener('click', async (e) => {
        if (playGame && e.target.tagName === 'BUTTON') {
            quizManager.isRight(ansPanel.innerHTML.trim()) &&
            e.target.dataset.val == '1'
                ? quizManager.levelUp(refreshLvlAndScore)
                : !quizManager.isRight(ansPanel.innerHTML.trim()) &&
                  e.target.dataset.val == '0'
                ? quizManager.levelUp(refreshLvlAndScore)
                : endGame()
        }
        e.stopPropagation()
    })

    if ((playGame = confirm('Play Game?'))) {
        newQuest()
    } else {
        alert(
            'If you change your mind, you can always click on MathQuiz title to start the game. Have a good day!'
        )
    }
})
