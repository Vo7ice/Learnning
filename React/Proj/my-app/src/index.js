import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class Square extends React.Component {

  render() {
    console.log("Square:: render index --> " + this.props.value);
    return (
      <button
        className="square"
        onClick={() => this.props.onClick()}
      >
        {this.props.value}
      </button>
    );
  }
}

class Board extends React.Component {

  renderSquare(i) {
    console.log("Board:: square index --> " + i + ",value::" + this.props.squares[i]);
    return (
      <Square 
        value={this.props.squares[i]}
        onClick={()=>this.props.onClick(i)}  
      />);
  }

  render() {
    return (
      <div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
      </div>
    );
  }
}

class Game extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      history: [{
        squares: Array(9).fill(null),
      }],
      xIsNext: true,
      stepNumber: 0,
      date: new Date(),
      increace: 0,
    }
  }

  handleClick(i) {
    console.log("handleClick :: " + i + ",length:" + this.state.history.squares);
    const history = this.state.history.slice(0, this.state.stepNumber + 1);
    const current = history[history.length - 1];
    console.log("handleClick :: history = " + history + ", current = " + current);
    const squares = current.squares.slice();
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    
    squares[i] = this.state.xIsNext ? 'X' : 'O';
    this.setState({
      history: history.concat([{
        squares: squares,
      }]),
      xIsNext: !this.state.xIsNext,
      stepNumber: history.length,
    });
  }

  jumpTo(step) {
    console.log("jumpTo :: " + step);
    this.setState({
      stepNumber:step,
      xIsNext: (step % 2) === 0,
    })
  }

  componentDidMount() {
    this.timeId = setInterval(
      () => this.tick(),
      1000
    );

    this.increaceId = setInterval(
      () => this.increaceTick(),
      2000
    );
  }

  componentWillUnmount() {
    clearInterval(this.timeId);
    clearInterval(this.increaceId);
  }

  tick() {
    this.setState({
      date: new Date()
    });
  }

  increaceTick() {
    this.setState({
      increace: this.state.increace + 1
    });
  }

  render() {
    const history = this.state.history;
    const current = history[this.state.stepNumber];
    const winner = calculateWinner(current.squares);
    const moves = history.map((step, move) => {
      const desc = move ? 
        'Go to move #' + move :
        'Go to game start';
      return (
        <li key={move}>
          <button onClick={() => this.jumpTo(move)}>{desc}</button>
        </li>
      );
    });
    let status;
    if (winner) {
      status = 'Winner: ' + winner;
    } else {
      status = 'Next player: ' + (this.state.xIsNext ? 'X' : 'O');
    }
    // let increaseMent = this.state.increase;
    // setInterval(() => {
    //   this.setState({
    //     increase: increaseMent + 1
    //   })
    // }, 1000);
    return (
      <div className="game">
        <div className="game-board">
          <Board 
            squares={current.squares}
            onClick={(i) => this.handleClick(i)}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>
          <div>
            <h1>
              {this.state.date.toLocaleTimeString()}
            </h1>
            <h2>
              {this.state.increace}
            </h2>
          </div>
          <ol>{moves}</ol>
        </div>
      </div>
    );
  }
}

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const[a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a];
    }
  }
  return null;
}

// ========================================

ReactDOM.render(
  <Game />,
  document.getElementById('root')
);
  