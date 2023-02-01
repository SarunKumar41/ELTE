function delegate(parent, child, when, what){
  function eventHandlerFunction(event){
      let eventTarget  = event.target
      let eventHandler = this
      let closestChild = eventTarget.closest(child)

      if(eventHandler.contains(closestChild)){
          what(event, closestChild)
      }
  }

  parent.addEventListener(when, eventHandlerFunction)
}


let table = document.querySelector('table');
const bulb = '💡';
let minutes = document.getElementById("minutes");
let seconds = document.getElementById("seconds");
let totalSeconds = 0;
let clockWork = 0;
let saveBulbsPositionIndex = new Array();
let winnerDetails = [];
winnerDetails["map"] = '';
winnerDetails["minutes"] = '';
winnerDetails["seconds"] = '';
winnerDetails["name"] = '';

const easyBColourPosition = [
  {
    index: 3,
    value: 1
  }, 
  {
    index: 8,
    value: 0
  }, 
  {
    index: 12,
    value: 2
  }, 
  {
    index: 21,
    value: -1
  }, 
  {
    index: 24,
    value: -1
  }, 
  {
    index: 27,
    value: -1
  }, 
  {
    index: 36,
    value: -1
  }, 
  {
    index: 40,
    value: 2
  }, 
  {
    index: 45,
    value: 3
  }
];

const advancedBColourPosition = [
  {
    index: 2,
    value: 0
  }, 
  {
    index: 4,
    value: -1
  }, 
  {
    index: 14,
    value: -1
  }, 
  {
    index: 16,
    value: -1
  }, 
  {
    index: 18,
    value: 3
  }, 
  {
    index: 20,
    value: -1
  }, 
  {
    index: 24,
    value: 1
  }, 
  {
    index: 28,
    value: 2
  }, 
  {
    index: 30,
    value: -1
  }, 
  {
    index: 32,
    value: -1
  },
  {
    index: 34,
    value: -1
  },
  {
    index: 44,
    value: -1
  }, 
  {
    index: 46,
    value: 2
  }
];

const extremeBColourPosition = [
  {
    index: 1,
    value: -1
  }, 
  {
    index: 15,
    value: 3
  }, 
  {
    index: 17,
    value: 2
  }, 
  {
    index: 19,
    value: -1
  }, 
  {
    index: 21,
    value: 0
  }, 
  {
    index: 22,
    value: -1
  }, 
  {
    index: 27,
    value: -1
  }, 
  {
    index: 34,
    value: -1
  }, 
  {
    index: 41,
    value: 1
  }, 
  {
    index: 44,
    value: -1
  }, 
  {
    index: 45,
    value: 1
  }, 
  {
    index: 46,
    value: -1
  }, 
  {
    index: 53,
    value: -1
  }, 
  {
    index: 54,
    value: -1
  }, 
  {
    index: 55,
    value: -1
  }, 
  {
    index: 58,
    value: 3
  }, 
  {
    index: 65,
    value: -1
  }, 
  {
    index: 72,
    value: 1
  }, 
  {
    index: 77,
    value: 0
  }, 
  {
    index: 78,
    value: -1
  }, 
  {
    index: 80,
    value: 3
  }, 
  {
    index: 82,
    value: -1
  }, 
  {
    index: 84,
    value: 0
  }, 
  {
    index: 98,
    value: 0
  }

];

function makeEasyTable()
{
  table = document.querySelector('table');
    for(let row = 0; row < 7; row++)
    {
      let newTR = document.createElement('tr')
      for(let column = 0; column < 7; column++)
      {
          let newTD = document.createElement('td');
          
          //7 * row + col
          //newTD.innerText = "4"
          newTD.dataset.rowIndex = row;
          newTD.dataset.columnIndex = column;
          newTD.dataset.valueNum = -1;
          
        if (easyBColourPosition.some(x => x.index == (row * 7 + column))) {
          newTD.classList.add('blockedCells');
          //newTD.setAttribute("style", "background-color: black");
          let ele = easyBColourPosition.filter(x => x.index == (row * 7 + column))[0];
          if(ele.value !== -1) { newTD.classList.add('withNum');}
          let check = ele.value !== -1 ? ele.value : "";
          newTD.innerText = check;
          newTD.dataset.valueNum = ele.value;
        }

        newTR.appendChild(newTD);
      }
      table.appendChild(newTR);
    }  

}

function makeAdvancedTable()
{
  table = document.querySelector('table');
  for(let row = 0; row < 7; row++)
  {
    let newTR = document.createElement('tr')
    for(let column = 0; column < 7; column++)
    {
        let newTD = document.createElement('td');
        
        //7 * row + col
        //newTD.innerText = "4"
        newTD.dataset.rowIndex = row;
        newTD.dataset.columnIndex = column;
        newTD.dataset.valueNum = -1;
        
      if (advancedBColourPosition.some(x => x.index == (row * 7 + column))) {
        newTD.classList.add('blockedCells');
        //newTD.setAttribute("style", "background-color: black");
        let ele = advancedBColourPosition.filter(x => x.index == (row * 7 + column))[0];
        if(ele.value !== -1) { newTD.classList.add('withNum');}
        let check = ele.value !== -1 ? ele.value : "";
        newTD.innerText = check;
        newTD.dataset.valueNum = ele.value;
      }

      newTR.appendChild(newTD);
    }
    table.appendChild(newTR);
  } 
}

function makeExtremeTable()
{
  table = document.querySelector('table');
  for(let row = 0; row < 10; row++)
  {
    let newTR = document.createElement('tr')
    for(let column = 0; column < 10; column++)
    {
        let newTD = document.createElement('td');
        
        //10 * row + col
        //newTD.innerText = "4"
        newTD.dataset.rowIndex = row;
        newTD.dataset.columnIndex = column;
        newTD.dataset.valueNum = -1;
        
      if (extremeBColourPosition.some(x => x.index == (row * 10 + column))) {
        newTD.classList.add('blockedCells');
        //newTD.setAttribute("style", "background-color: black");
        let ele = extremeBColourPosition.filter(x => x.index == (row * 10 + column))[0];
        if(ele.value !== -1) { newTD.classList.add('withNum');}
        let check = ele.value !== -1 ? ele.value : "";
        newTD.innerText = check;
        newTD.dataset.valueNum = ele.value;
      }

      newTR.appendChild(newTD);
    }
    table.appendChild(newTR);
  }
}

let tableData = [] 

/**
 * manages the task after a event(click in this case) on any table data and illuminates accordingly
 * @param {*} event 
 * @param {*} element 
 */
function colorClickedData(event, element)
{
  tableData = Array.from(document.querySelectorAll('td'));
  
  const tableRow = document.querySelectorAll('tr');
  const row = element.dataset.rowIndex;
  const column = element.dataset.columnIndex;
  const tableLen = tableRow.length;
  const innerIndex = (parseFloat(row) * parseFloat(tableLen)) + parseFloat(column);
  const maxIndex = ( ((tableLen-1) * tableLen) + (tableLen-1) );
  

  if(ifBulbAlreadyExist(event,element) == false)
  {
    let cond = checkAdjacentPossibilityForPlacing(row,column,tableLen,innerIndex,maxIndex);
    if(element.innerText !== bulb && !element.classList.contains('blockedCells') && cond)
    {
      for(let t of tableData)
      {
        if(row === t.dataset.rowIndex)
        {
          let i = 0;
          while((tableData[innerIndex+i].classList.contains('blockedCells')==false) && (tableData[innerIndex+i].dataset.rowIndex === t.dataset.rowIndex)  )
          {
            tableData[innerIndex+i].classList.add('coloured');
            i+=1;
            if(innerIndex+i > maxIndex)
            {
              break;
            }
          }
          let j = 0;
          while((tableData[innerIndex-j].classList.contains('blockedCells')==false) && tableData[innerIndex-j].dataset.rowIndex === t.dataset.rowIndex )
          {
            tableData[innerIndex-j].classList.add('coloured');
            j+=1;
            if(innerIndex-j < 0)
            {
              break;
            }
          }
          
        }
        if(column === t.dataset.columnIndex)
        {
          let i = 0;
          while((tableData[innerIndex+i*tableLen].classList.contains('blockedCells')==false) && (tableData[innerIndex+i*tableLen].dataset.columnIndex === t.dataset.columnIndex )  )
          {
            tableData[innerIndex+i*tableLen].classList.add('coloured');
            i+=1;
            if(innerIndex+i*tableLen > maxIndex)
            {
              break;
            }
          }
          let j = 0;
          while((tableData[innerIndex-j*tableLen].classList.contains('blockedCells')==false) && tableData[innerIndex-j*tableLen].dataset.columnIndex === t.dataset.columnIndex )
          {
            tableData[innerIndex-j*tableLen].classList.add('coloured');
            j+=1;
            if(innerIndex-j*tableLen < 0)
            {
              break;
            }
          }
  
        }
      }
      element.innerText = bulb;
      decreasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex);
    }
    else if(element.innerText === bulb && !element.classList.contains('blockedCells')  )
    {
      for(let t of tableData)
      {
        if(row === t.dataset.rowIndex)
        {
          let i = 0;
          while((tableData[innerIndex+i].classList.contains('blockedCells')==false) && (tableData[innerIndex+i].dataset.rowIndex === t.dataset.rowIndex)  )
          {
            tableData[innerIndex+i].classList.remove('coloured');
            i+=1;
            if(innerIndex+i > maxIndex)
            {
              break;
            }
          }
          let j = 0;
          while((tableData[innerIndex-j].classList.contains('blockedCells')==false) && tableData[innerIndex-j].dataset.rowIndex === t.dataset.rowIndex )
          {
            tableData[innerIndex-j].classList.remove('coloured');
            j+=1;
            if(innerIndex-j < 0)
            {
              break;
            }
          }
          
        }
        if(column === t.dataset.columnIndex)
        {
          let i = 0;
          while((tableData[innerIndex+i*tableLen].classList.contains('blockedCells')==false) && (tableData[innerIndex+i*tableLen].dataset.columnIndex === t.dataset.columnIndex )  )
          {
            tableData[innerIndex+i*tableLen].classList.remove('coloured');
            i+=1;
            if(innerIndex+i*tableLen > maxIndex)
            {
              break;
            }
          }
          let j = 0;
          while((tableData[innerIndex-j*tableLen].classList.contains('blockedCells')==false) && tableData[innerIndex-j*tableLen].dataset.columnIndex === t.dataset.columnIndex )
          {
            tableData[innerIndex-j*tableLen].classList.remove('coloured');
            j+=1;
            if(innerIndex-j*tableLen < 0)
            {
              break;
            }
          }
  
        }
      }
      element.innerText = '';
      increasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex);
    }
    else if(element.innerText !== bulb && !element.classList.contains('blockedCells') && cond == false)
    {
      setTimeout(() => {element.classList.remove('errorCells')}, 500);
      element.classList.add('errorCells');
    }
    else {}
    leftColor();
    colourAllZeroedInnerText();
    deColourNonZeroedInnerText();
    
  }
  
  if(ifBulbAlreadyExist(event,element))
  {
      if(element.classList.contains('coloured')) { element.classList.remove('coloured');}
      setTimeout(() => {element.classList.remove('errorCells')}, 500);
      setTimeout(() => {element.classList.add('coloured')},500);
      element.classList.add('errorCells');
  }

  setTimeout(() => { checkGameFinished(); },500);

}

function colorClickedData2(element)
{
  tableData = Array.from(document.querySelectorAll('td'));
  
  const tableRow = document.querySelectorAll('tr');
  const row = element.dataset.rowIndex;
  const column = element.dataset.columnIndex;
  const tableLen = tableRow.length;
  const innerIndex = (parseFloat(row) * parseFloat(tableLen)) + parseFloat(column);
  const maxIndex = ( ((tableLen-1) * tableLen) + (tableLen-1) );
  
    // if(element.innerText !== bulb && !element.classList.contains('blockedCells'))
    // {
      for(let t of tableData)
      {
        if(row === t.dataset.rowIndex)
        {
          let i = 0;
          while((tableData[innerIndex+i].classList.contains('blockedCells')==false) && (tableData[innerIndex+i].dataset.rowIndex === t.dataset.rowIndex)  )
          {
            tableData[innerIndex+i].classList.add('coloured');
            i+=1;
            if(innerIndex+i > maxIndex)
            {
              break;
            }
          }
          let j = 0;
          while((tableData[innerIndex-j].classList.contains('blockedCells')==false) && tableData[innerIndex-j].dataset.rowIndex === t.dataset.rowIndex )
          {
            tableData[innerIndex-j].classList.add('coloured');
            j+=1;
            if(innerIndex-j < 0)
            {
              break;
            }
          }
          
        }
        if(column === t.dataset.columnIndex)
        {
          let i = 0;
          while((tableData[innerIndex+i*tableLen].classList.contains('blockedCells')==false) && (tableData[innerIndex+i*tableLen].dataset.columnIndex === t.dataset.columnIndex )  )
          {
            tableData[innerIndex+i*tableLen].classList.add('coloured');
            i+=1;
            if(innerIndex+i*tableLen > maxIndex)
            {
              break;
            }
          }
          let j = 0;
          while((tableData[innerIndex-j*tableLen].classList.contains('blockedCells')==false) && tableData[innerIndex-j*tableLen].dataset.columnIndex === t.dataset.columnIndex )
          {
            tableData[innerIndex-j*tableLen].classList.add('coloured');
            j+=1;
            if(innerIndex-j*tableLen < 0)
            {
              break;
            }
          }
  
        }
      }
      element.innerText = bulb;
      decreasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex);
    //}
    // else if(element.innerText === bulb && !element.classList.contains('blockedCells')  )
    // {
    //   for(let t of tableData)
    //   {
    //     if(row === t.dataset.rowIndex)
    //     {
    //       let i = 0;
    //       while((tableData[innerIndex+i].classList.contains('blockedCells')==false) && (tableData[innerIndex+i].dataset.rowIndex === t.dataset.rowIndex)  )
    //       {
    //         tableData[innerIndex+i].classList.remove('coloured');
    //         i+=1;
    //         if(innerIndex+i > maxIndex)
    //         {
    //           break;
    //         }
    //       }
    //       let j = 0;
    //       while((tableData[innerIndex-j].classList.contains('blockedCells')==false) && tableData[innerIndex-j].dataset.rowIndex === t.dataset.rowIndex )
    //       {
    //         tableData[innerIndex-j].classList.remove('coloured');
    //         j+=1;
    //         if(innerIndex-j < 0)
    //         {
    //           break;
    //         }
    //       }
          
    //     }
    //     if(column === t.dataset.columnIndex)
    //     {
    //       let i = 0;
    //       while((tableData[innerIndex+i*tableLen].classList.contains('blockedCells')==false) && (tableData[innerIndex+i*tableLen].dataset.columnIndex === t.dataset.columnIndex )  )
    //       {
    //         tableData[innerIndex+i*tableLen].classList.remove('coloured');
    //         i+=1;
    //         if(innerIndex+i*tableLen > maxIndex)
    //         {
    //           break;
    //         }
    //       }
    //       let j = 0;
    //       while((tableData[innerIndex-j*tableLen].classList.contains('blockedCells')==false) && tableData[innerIndex-j*tableLen].dataset.columnIndex === t.dataset.columnIndex )
    //       {
    //         tableData[innerIndex-j*tableLen].classList.remove('coloured');
    //         j+=1;
    //         if(innerIndex-j*tableLen < 0)
    //         {
    //           break;
    //         }
    //       }
  
    //     }
    //   }
    //   element.innerText = '';
    //   increasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex);
    // }
   
    //leftColor();
    colourAllZeroedInnerText();
    deColourNonZeroedInnerText();
    
}

/**
 * goes through the whole table and look for illuminated td and then fills it's rows and column as required 
 */
function leftColor()
{
  tableData = Array.from(document.querySelectorAll('td'));
  for(let t of tableData)
  {
    let row;
    let tableRow;
    let column;
    let innerIndex;
    let maxIndex;
    let tableLen ;
    if(t.innerText === bulb)
    {
      
      tableRow = document.querySelectorAll('tr');
      row = t.dataset.rowIndex;
      column = t.dataset.columnIndex;
      tableLen = parseFloat(tableRow.length);
      innerIndex = (parseFloat(row) * parseFloat(tableRow.length)) + parseFloat(column);
      maxIndex = ( ((tableRow.length-1) * tableRow.length) + (tableRow.length-1) );

    }
      if(row === t.dataset.rowIndex)
      {
        let i = 0;
        while((tableData[innerIndex+i].classList.contains('blockedCells')==false) && (tableData[innerIndex+i].dataset.rowIndex === t.dataset.rowIndex)  )
        {
          tableData[innerIndex+i].classList.add('coloured');
          i+=1;
          if(innerIndex+i > maxIndex)
          {
            break;
          }
        }
        let j = 0;
        while((tableData[innerIndex-j].classList.contains('blockedCells')==false) && tableData[innerIndex-j].dataset.rowIndex === t.dataset.rowIndex )
        {
          tableData[innerIndex-j].classList.add('coloured');
          j+=1;
          if(innerIndex-j < 0)
          {
            break;
          }
        }
        
      }
      if(column === t.dataset.columnIndex)
      {
        let i = 0;
        while((tableData[innerIndex+i*tableLen].classList.contains('blockedCells')==false) && (tableData[innerIndex+i*tableLen].dataset.columnIndex === t.dataset.columnIndex )  )
        {
          tableData[innerIndex+i*tableLen].classList.add('coloured');
          i+=1;
          if(innerIndex+i*tableLen > maxIndex)
          {
            break;
          }
        }
        let j = 0;
        while((tableData[innerIndex-j*tableLen].classList.contains('blockedCells')==false) && tableData[innerIndex-j*tableLen].dataset.columnIndex === t.dataset.columnIndex )
        {
          tableData[innerIndex-j*tableLen].classList.add('coloured');
          j+=1;
          if(innerIndex-j*tableLen < 0)
          {
            break;
          }
        }

      }
    
  }
}

/**
 * 
 * @param {*} event 
 * @param {*} element 
 * @returns boolean and checks if there is a bulb that already exists in the same row or coloumn as the element.
 * Note: It checks only between blocked cells if there exist blocked cells in the scope of element's row or coloumn.
 */
function ifBulbAlreadyExist(event, element)
{
  tableData = Array.from(document.querySelectorAll('td'));
  let ifthere = false;
  const tableRow = document.querySelectorAll('tr');
  const row = element.dataset.rowIndex;
  const column = element.dataset.columnIndex;
  const tableLen = tableRow.length;
  const innerIndex = (parseFloat(row) * parseFloat(tableLen)) + parseFloat(column);
  const maxIndex = ( ((tableLen-1) * tableLen) + (tableLen-1) );

  for(let t of tableData)
  {
    if(row === t.dataset.rowIndex)
    {
      let i = 0;
      while((tableData[innerIndex+i].classList.contains('blockedCells')==false) && (tableData[innerIndex+i].dataset.rowIndex === t.dataset.rowIndex)  )
      {
        if(tableData[innerIndex+i].innerText === bulb && (innerIndex+i) != innerIndex ) { ifthere =  true;}
        i+=1;
        if(innerIndex+i > maxIndex)
        {
          break;
        }
      }
      let j = 0;
      while((tableData[innerIndex-j].classList.contains('blockedCells')==false) && tableData[innerIndex-j].dataset.rowIndex === t.dataset.rowIndex )
      {
        if(tableData[innerIndex-j].innerText === bulb && (innerIndex-j) != innerIndex) { ifthere =  true;}
        j+=1;
        if(innerIndex-j < 0)
        {
          break;
        }
      }
      
    }
    if(column === t.dataset.columnIndex)
    {
      let i = 0;
      while((tableData[innerIndex+i*tableLen].classList.contains('blockedCells')==false) && (tableData[innerIndex+i*tableLen].dataset.columnIndex === t.dataset.columnIndex )  )
      {
        if(tableData[innerIndex+i*tableLen].innerText === bulb && (innerIndex+i*tableLen) != innerIndex) { ifthere = true;}
        i+=1;
        if(innerIndex+i*tableLen > maxIndex)
        {
          break;
        }
      }
      let j = 0;
      while((tableData[innerIndex-j*tableLen].classList.contains('blockedCells')==false) && tableData[innerIndex-j*tableLen].dataset.columnIndex === t.dataset.columnIndex )
      {
        if(tableData[innerIndex-j*tableLen].innerText === bulb && (innerIndex-j*tableLen) != innerIndex) { ifthere = true;}
        j+=1;
        if(innerIndex-j*tableLen < 0)
        {
          break;
        }
      }

    }
  }

  return ifthere;
}

/**
 * 
 * @param {*} row : it is the row index of the table data element
 * @param {*} column : it is the column of the table data element
 * @param {*} tableLen : length of the table
 * @param {*} innerIndex : index of the element in table
 * @param {*} maxIndex : maximum index value possible in the table
 * @returns if the table data is correct to place bulb on it
 */
function checkAdjacentPossibilityForPlacing(row,column,tableLen,innerIndex,maxIndex)
{
  tableData = Array.from(document.querySelectorAll('td'));
  let checkSides = true;

  const onRight = innerIndex+1;
  if((onRight) <= maxIndex )
  {
    if(tableData[onRight].classList.contains('blockedCells') && tableData[onRight].classList.contains('withNum') && row === tableData[onRight].dataset.rowIndex)
    {
      let numCompare = parseFloat(tableData[onRight].dataset.valueNum);
      if(numCompare === 0)
      {
        //tableData[onRight].classList.add('okColoured')
        checkSides = false;
      }
    }
  }
  const onLeft = innerIndex-1;
  if(onLeft >= 0 )
  {
    if(tableData[onLeft].classList.contains('blockedCells') && tableData[onLeft].classList.contains('withNum') && row === tableData[onLeft].dataset.rowIndex)
    {
      let numCompare = parseFloat(tableData[onLeft].dataset.valueNum);
      if( numCompare === 0)
      {
        //tableData[onLeft].classList.add('okColoured');
        checkSides = false;
      }
    }
  }

  const onUpper = innerIndex - tableLen;
  if(onUpper >= 0 )
  {
    if(tableData[onUpper].classList.contains('blockedCells') && tableData[onUpper].classList.contains('withNum') && column === tableData[onUpper].dataset.columnIndex)
    {
      let numCompare = parseFloat(tableData[onUpper].dataset.valueNum);
      if( numCompare === 0)
      {
        //tableData[onUpper].classList.add('okColoured');
        checkSides = false;
      }
    }
  }
  const onLower = innerIndex + tableLen;
  if(onLower <= maxIndex )
  {
    if(tableData[onLower].classList.contains('blockedCells') && tableData[onLower].classList.contains('withNum') && column === tableData[onLower].dataset.columnIndex)
    {
      let numCompare = parseFloat(tableData[onLower].dataset.valueNum);
      if( numCompare === 0)
      {
        //tableData[onLower].classList.add('okColoured');
        checkSides = false;
      }
    }
  }

    return checkSides;
}

/**
 * 
 * @param {*} row : it is the row index of the table data element
 * @param {*} column : it is the column of the table data element
 * @param {*} tableLen : length of the table
 * @param {*} innerIndex : index of the element in table
 * @param {*} maxIndex : maximum index value possible in the table
 * It decreases the valueNum of each blockedCell table data containing valueNum more than 0(does not affect those with blanked innerText )
 */
function decreasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex)
{
  tableData = Array.from(document.querySelectorAll('td'));
  let checkSides = true;

  const onRight = innerIndex+1;
  if((onRight)<=maxIndex )
  {
    if(tableData[onRight].classList.contains('blockedCells') && tableData[onRight].classList.contains('withNum') && row === tableData[onRight].dataset.rowIndex)
    {
      let numCompare = parseFloat(tableData[onRight].dataset.valueNum);
      if(numCompare > 0)
      {
        numCompare -= 1;
        tableData[onRight].dataset.valueNum = numCompare; 
      }
      //console.log(`Right index dataset valueNum: ` + tableData[onRight].dataset.valueNum);
    }
  }

  const onLeft = innerIndex-1;
  if(onLeft >= 0 )
  {
    if(tableData[onLeft].classList.contains('blockedCells') && tableData[onLeft].classList.contains('withNum') && row === tableData[onLeft].dataset.rowIndex)
    {
      let numCompare = parseFloat(tableData[onLeft].dataset.valueNum);
      if( numCompare > 0)
      {
        numCompare -= 1;
        tableData[onLeft].dataset.valueNum = numCompare;
      }
      //console.log(`Left index dataset valueNum: ` +tableData[onLeft].dataset.valueNum);
    }
  }

  const onUpper = innerIndex - tableLen;
  if(onUpper >= 0 )
  {
    if(tableData[onUpper].classList.contains('blockedCells') && tableData[onUpper].classList.contains('withNum') && column === tableData[onUpper].dataset.columnIndex)
    {
      let numCompare = parseFloat(tableData[onUpper].dataset.valueNum);
      if( numCompare > 0)
      {
        numCompare -= 1;
        tableData[onUpper].dataset.valueNum = numCompare;
      }
      //console.log(`Above index dataset valueNum: ` +tableData[onUpper].dataset.valueNum);
    }
  }

  const onLower = innerIndex + tableLen;
  if(onLower <= maxIndex )
  {
    if(tableData[onLower].classList.contains('blockedCells') && tableData[onLower].classList.contains('withNum') && column === tableData[onLower].dataset.columnIndex ) 
    {
      let numCompare = parseFloat(tableData[onLower].dataset.valueNum);
      if( numCompare > 0)
      {
        numCompare -= 1;
        tableData[onLower].dataset.valueNum = numCompare;
      }
      //console.log(`Below index dataset valueNum: ` +tableData[onLower].dataset.valueNum);
    }
  }
}

/**
 * 
 * @param {*} row : it is the row index of the table data element
 * @param {*} column : it is the column of the table data element
 * @param {*} tableLen : length of the table
 * @param {*} innerIndex : index of the element in table
 * @param {*} maxIndex : maximum index value possible in the table
 * It increases the valueNum of each blockedCell table data containing valueNum more than 0(does not affect those with blanked innerText )
 */
function increasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex)
{
  tableData = Array.from(document.querySelectorAll('td'));
  let checkSides = true;
  
  const onRight = innerIndex+1;
  if((onRight)<=maxIndex )
  {
    if(tableData[onRight].classList.contains('blockedCells') && tableData[onRight].classList.contains('withNum') && row === tableData[onRight].dataset.rowIndex)
    {
      let numCompare = parseFloat(tableData[onRight].dataset.valueNum);
      if(numCompare >= 0)
      {
        numCompare += 1;
        tableData[onRight].dataset.valueNum = numCompare; 
      }
      //console.log(`Right index dataset valueNum: ` + tableData[onRight].dataset.valueNum);
    }
  }

  const onLeft = innerIndex-1;
  if(onLeft >= 0 )
  {
    if(tableData[onLeft].classList.contains('blockedCells') && tableData[onLeft].classList.contains('withNum') && row === tableData[onLeft].dataset.rowIndex)
    {
      let numCompare = parseFloat(tableData[onLeft].dataset.valueNum);
      if( numCompare >= 0)
      {
        numCompare += 1;
        tableData[onLeft].dataset.valueNum = numCompare;
      }
      //console.log(`Left index dataset valueNum: ` + tableData[onLeft].dataset.valueNum);
    }
  }

  const onUpper = innerIndex - tableLen;
  if(onUpper >= 0 )
  {
    if(tableData[onUpper].classList.contains('blockedCells') && tableData[onUpper].classList.contains('withNum') && column === tableData[onUpper].dataset.columnIndex)
    {
      let numCompare = parseFloat(tableData[onUpper].dataset.valueNum);
      if( numCompare >= 0)
      {
        numCompare += 1;
        tableData[onUpper].dataset.valueNum = numCompare;
      }
      //console.log(`Above index dataset valueNum: ` + tableData[onUpper].dataset.valueNum);
    }
  }

  const onLower = innerIndex + tableLen;
  if(onLower <= maxIndex )
  {
    if(tableData[onLower].classList.contains('blockedCells') && tableData[onLower].classList.contains('withNum') && column === tableData[onLower].dataset.columnIndex)
    {
      let numCompare = parseFloat(tableData[onLower].dataset.valueNum);
      if( numCompare >= 0)
      {
        numCompare += 1;
        tableData[onLower].dataset.valueNum = numCompare;
      }
      //console.log(`Below index dataset valueNum: ` + tableData[onLower].dataset.valueNum);
    }
  }
}

/**
 * It turns all the table date element color to green when all the required number of bulbs are present.
 */
function colourAllZeroedInnerText()
{
  tableData = Array.from(document.querySelectorAll('td'));
  tableData.filter( t => t.classList.contains('blockedCells') && t.dataset.valueNum == 0).forEach(t => t.classList.add('okColoured'));
}

/**
 * It turns all the table date element color back to previous color when all the required number of bulbs are not present.
 */
function deColourNonZeroedInnerText()
{
  tableData = Array.from(document.querySelectorAll('td'));
  tableData.filter( t => t.classList.contains('blockedCells') && (t.dataset.valueNum) > 0 && t.classList.contains('okColoured')).forEach(t => t.classList.remove('okColoured'));
}


let textJustOnce =0;
/**
 * This function checks if all the non-blocked cells are lit and all the required number of bulbs are present in right place
 */
function checkGameFinished()
{
  tableData = Array.from(document.querySelectorAll('td'));
  const isAllColoured = tableData.filter(t => !t.classList.contains('blockedCells')).every(t => t.classList.contains('coloured')) ;
  const isAllOkColured = tableData.filter(t => t.classList.contains('withNum')).every(t => t.classList.contains('okColoured'));
  //console.log( tableData.filter(t => !t.classList.contains('blockedCells')).every(t => t.classList.contains('coloured')) );
  //let textJustOnce = 0;
  if(isAllColoured && isAllOkColured ) 
  {
    if(textJustOnce == 0)
    {
      let congratulatePlayer = document.querySelector('#playerName');
      let congrats = congratulatePlayer.innerText;
      congrats += "Congrats!!! You won the game \n You can start a new Game";
      congratulatePlayer.innerText = congrats;
      window.alert('Congrats! You won the game');
    }
    textJustOnce +=1;
    //nonStop = false;
    // minutes.innerText = '00';
    // seconds.innerText = '00';
    //getWinningDetails();
    resetButton.disabled = true;
    saveButton.disabled = true;
    resetButton.style.display = 'none';
    setScoreBoard();
    
  }
  
}


/**
 * This function resets the table and starts the game again
 */
function resetGameFunction()
{
  // let makeInputForPlayer = document.querySelector('#playerName');
  // makeInputForPlayer.innerText = makeInputForPlayer.innerText;
  let clock = document.querySelector('#clock');
  clock.style.display = 'block';
  totalSeconds = 0;
  textJustOnce = 0;
  clockRunning(totalSeconds);
  let makeInputForPlayer = document.querySelector('#playerName');
  makeInputForPlayer.innerText = `Player name: ${winnerDetails["name"]} 👑`
  tableData = Array.from(document.querySelectorAll('td'));
  for( let t of tableData)
  {
    const tableRow = document.querySelectorAll('tr');
    const row = t.dataset.rowIndex;
    const column = t.dataset.columnIndex;
    const tableLen = tableRow.length;
    const innerIndex = (parseFloat(row) * parseFloat(tableLen)) + parseFloat(column);
    const maxIndex = ( ((tableLen-1) * tableLen) + (tableLen-1) );
    if(!t.classList.contains('blockedCells') )
    {
      if(t.classList.contains('coloured'))
      {
        if(t.innerText === bulb)
        {
          t.innerText = '';
          increasingBlockedCellsNumValue(row,column,tableLen,innerIndex,maxIndex);
        }
        t.classList.remove('coloured');
        deColourNonZeroedInnerText();
      }
    }

  }
  leftColor();
}

function newGameEasy()
{
  table = document.querySelector('table');
  if(table != null) {table.remove();}
  
  textJustOnce = 0;
  resetButton.style.display = 'inline-block';
  saveButton.style.display = 'inline-block';
  resetButton.disabled = false;
  //saveButton.style.display = 'inline-block';
  saveButton.disabled = false;
  const scoreboard = document.querySelector('li#scoreBoard');
  scoreboard.style.display = 'none';
  let playerNameInput = document.querySelector('input');
  let makeInputForPlayer = document.querySelector('#playerName');
  makeInputForPlayer.style.display = 'content';
  winnerDetails["name"] = playerNameInput.value;
  winnerDetails["map"] = 'Easy';
  makeInputForPlayer.innerText = `Player name: ${playerNameInput.value} 👑`
  playerNameInput.style.display = 'none';
  const firstButton = document.querySelector('#reset');
  table = document.createElement('table');
  firstButton.insertAdjacentElement('beforebegin',table);
  makeEasyTable();
  delegate(table, 'td', 'click', colorClickedData)
  let clock = document.querySelector('#clock');
  clock.style.display = 'block'; 
  totalSeconds = 0;
  clockRunning(totalSeconds);
}

function newGameAdvanced()
{
  table = document.querySelector('table');
  if(table != null) {table.remove();}
  textJustOnce = 0;
  resetButton.style.display = 'inline-block';
  saveButton.style.display = 'inline-block';
  resetButton.disabled = false;
  //saveButton.style.display = 'inline-block';
  saveButton.disabled = false;
  const scoreboard = document.querySelector('li#scoreBoard');
  scoreboard.style.display = 'none';
  let playerNameInput = document.querySelector('input');
  winnerDetails["name"] = playerNameInput.value;
  winnerDetails["map"] = 'Advanced';
  let makeInputForPlayer = document.querySelector('#playerName');
  makeInputForPlayer.style.display = 'content';
  makeInputForPlayer.innerText = `Player name: ${playerNameInput.value} 👑`
  playerNameInput.style.display = 'none';
  const firstButton = document.querySelector('#reset');
  table = document.createElement('table');
  firstButton.insertAdjacentElement('beforebegin',table);
  makeAdvancedTable();
  delegate(table, 'td', 'click', colorClickedData)
  let clock = document.querySelector('#clock');
  clock.style.display = 'block'; 
  totalSeconds = 0;
  clockRunning(totalSeconds);
}

function newGameExtreme()
{
  table = document.querySelector('table');
  if(table != null) {table.remove();}
  textJustOnce = 0;
  resetButton.style.display = 'inline-block';
  saveButton.style.display = 'inline-block';
  resetButton.disabled = false;
  //saveButton.style.display = 'inline-block';
  saveButton.disabled = false;
  const scoreboard = document.querySelector('li#scoreBoard');
  scoreboard.style.display = 'none';
  let playerNameInput = document.querySelector('input');
  winnerDetails["name"] = playerNameInput.value;
  winnerDetails["map"] = 'Extreme';
  let makeInputForPlayer = document.querySelector('#playerName');
  makeInputForPlayer.style.display = 'content';
  makeInputForPlayer.innerText = `Player name: ${playerNameInput.value} 👑`
  playerNameInput.style.display = 'none';
  const firstButton = document.querySelector('#reset');
  table = document.createElement('table');
  firstButton.insertAdjacentElement('beforebegin',table);
  makeExtremeTable();
  delegate(table, 'td', 'click', colorClickedData)
  let clock = document.querySelector('#clock');
  clock.style.display = 'block'; 
  totalSeconds = 0;
  clockRunning(totalSeconds);
}

function newGame()
{
  newGameHelper();
  const playerName = document.querySelector('#playerName');
  playerName.style.display = 'block';
  table = document.querySelector('table');
  if(table != null) {table.remove();}
  resetButton.style.display = 'inline-block';
  saveButton.style.display = 'inline-block';
  let clock = document.querySelector('#clock');
  clock.style.display = 'none';
  //resetButton.disabled = false;
  //newGameButton.disabled = false;
  let makeInputForPlayer = document.querySelector('#playerName');
  makeInputForPlayer.style.display = 'content';
  const ask = "Please, enter your name. Click the new Game button once again and choose the level of difficulty!!!";
  makeInputForPlayer.innerText = ask;
  if((document.querySelectorAll('input')).length == 1)
  {
    let playerNameInput = document.querySelector('input');
    playerNameInput.style.display = 'block';
  }
  if((document.querySelectorAll('input')).length == 0)
  {
    let playerNameInput = document.createElement('input');
    playerNameInput.setAttribute("type","text");
    makeInputForPlayer.insertAdjacentElement('afterend',playerNameInput);
  }

  resetButton.style.display = 'none';
  saveButton.style.display = 'none';
  // let hideResumeButton = document.querySelector('#resume');
  // hideResumeButton.style.display = 'none';
  

}

function newGameHelper()
{
  let easyButtonHide = document.querySelector('#easy');
  easyButtonHide.style.display = easyButtonHide.style.display === 'none' ? 'inline-block' : "none";

  let advancedButtonHide = document.querySelector('#advanced');
  advancedButtonHide.style.display = advancedButtonHide.style.display === 'none' ? 'inline-block' : "none";

  let extremeButtonHide = document.querySelector('#extreme');
  extremeButtonHide.style.display = extremeButtonHide.style.display === 'none' ? 'inline-block' : "none";
}

// All three functions( clockRunning, setTime and timeHelper) below are for handling clock
function clockRunning(totalSeconds)
{
  minutes = document.getElementById("minutes");
  seconds = document.getElementById("seconds");

    clockWork +=1;
    if(clockWork == 1){ setInterval(setTime, 1000);}
  
}

function setTime()
{
    ++totalSeconds;
    seconds.innerText = timeHelper(totalSeconds%60);
    minutes.innerText = timeHelper(parseInt(totalSeconds/60));
}

function timeHelper(val)
{
    let displayStr = val + "";
    return (displayStr.length < 2) ? "0" + displayStr : displayStr; 
}

/**
 * This function collects the data of the player which includes the name, map and winning time
 */
function getWinningDetails()
{
  minutes = document.getElementById("minutes");
  seconds = document.getElementById("seconds");

  //console.log(minutes.innerText + ":" + seconds.innerText);
  winnerDetails["minutes"] = minutes.innerText;
  winnerDetails["seconds"] = seconds.innerText;
  winnerDetails["name"] = winnerDetails["name"];
  winnerDetails["map"] = winnerDetails["map"];
  console.log(winnerDetails);

}

/**
 * This function collects all the bulb indexes and also player's details of the time it is called
 */
function gettingBulbsForSaving()
{
  const tableLen = (document.querySelectorAll('tr')).length;
  // const row = element.dataset.rowIndex;
  // const column = element.dataset.columnIndex;
  // const tableLen = tableRow.length;
  // const innerIndex = (parseFloat(row) * parseFloat(tableLen)) + parseFloat(column);
  getWinningDetails();
  permaSave('detailsPermaName', winnerDetails["name"]);
  permaSave('detailsPermaMap', winnerDetails["map"]);
  permaSave('detailsPermaMinutes', winnerDetails["minutes"]);
  permaSave('detailsPermaSeconds', winnerDetails["seconds"]);

  tableData = Array.from(document.querySelectorAll('td'));
  //console.log(tableLen);
  saveBulbsPositionIndex.length = 0;
  tableData.filter( t => t.innerText === bulb).forEach( t =>
    saveBulbsPositionIndex.push( parseFloat(t.dataset.rowIndex) * tableLen + parseFloat(t.dataset.columnIndex))
  );
  window.alert("The game has been saved");
  permaSave('indexPerma',saveBulbsPositionIndex);
  console.log(saveBulbsPositionIndex);
  let hideResumeButton = document.querySelector('#resume');
  hideResumeButton.style.display = 'inline-block';
  saveButton.style.display = 'none';
  table = document.querySelector('table');
  if(table != null) {table.remove();}
  let clock = document.querySelector('#clock');
  if(clock != null) { clock.style.display = 'none';}
  let playerName = document.querySelector('#playerName');
  if(playerName != null) { playerName.style.display = 'none';}
}

function makeMapForResume()
{
  table = document.querySelector('table');
  if(table != null) {table.remove();}
  textJustOnce = 0;
  resetButton.disabled = false;
  saveButton.disabled = false;
  window.alert('The game is going to resume where the previous player left it');
  //let playerNameInput = document.querySelector('input');
  let makeInputForPlayer = document.querySelector('#playerName');
  makeInputForPlayer.style.display = 'content';
  winnerDetails["name"] = permaLoad('detailsPermaName');
  winnerDetails["map"] = permaLoad('detailsPermaMap');
  saveButton.style.display = 'inline-block';
  //getWinningDetails();
  makeInputForPlayer.innerText =  `Player name: ${winnerDetails["name"]}`; //`Player name: ${winnerDetails["name"]} 👑`
  //playerNameInput.style.display = 'none';

  const firstButton = document.querySelector('#reset');
  table = document.createElement('table');
  firstButton.insertAdjacentElement('beforebegin',table);
  if(winnerDetails["map"] == 'Easy') {makeEasyTable(); }
  else if(winnerDetails["map"] == 'Advanced') {makeAdvancedTable(); }
  else if(winnerDetails["map"] == 'Extreme') {makeExtremeTable(); }
  else{}
  
  let tableLen = document.querySelectorAll('tr').length ;
  saveBulbsPositionIndex.length = 0;
  saveBulbsPositionIndex = Array.from((permaLoad('indexPerma').split(','))); //permaLoad('indexPerma');
  tableData = Array.from(document.querySelectorAll('td'));
  tableData.filter(t => !t.classList.contains('blockedCells') && saveBulbsPositionIndex.some( x => x == parseFloat(t.dataset.rowIndex) * tableLen + parseFloat(t.dataset.columnIndex) )).forEach(t => colorClickedData2(t)); //t.innerText = bulb);
  //colorClickedData('click', 'td');
  leftColor();
  colourAllZeroedInnerText();
  deColourNonZeroedInnerText();
  let scoreBoard = document.querySelector('#scoreBoard');
  scoreBoard.style.display = 'none';

  winnerDetails["minutes"] = permaLoad('detailsPermaMinutes');
  winnerDetails["seconds"] = permaLoad('detailsPermaSeconds');
  
  let clock = document.querySelector('#clock');
  clock.style.display = 'block'; 
  totalSeconds = parseFloat(winnerDetails["minutes"]) * 60 + parseFloat(winnerDetails["seconds"]);
  console.log(totalSeconds);
  clockRunning(totalSeconds);
  delegate(table, 'td', 'click', colorClickedData)
  

} 


function setScoreBoard()
{
  table = document.querySelector('table');
  table.remove();
  const scoreboard = document.querySelector('li#scoreBoard');
  scoreboard.style.display = 'block';
  const clock = document.querySelector('#clock');
  clock.style.display = 'none';
  getWinningDetails();
  const name = document.querySelector('#name');
  const mapLevel = document.querySelector('#mapLevel');
  const timeTaken = document.querySelector('#timeTaken');


  name.innerText =  `Player's Name :  ${winnerDetails["name"]}`;
  mapLevel.innerText = `Map's Level :  ${winnerDetails["map"]}`;
  timeTaken.innerText = `Time taken : ${winnerDetails["minutes"]}:${winnerDetails["seconds"]}`;

}

// function permaSave(attributeName, value){
//   window.localStorage.setItem(attributeName, JSON.stringify(value))
// }

// function permaSaveText(attributeName, value){
//   window.localStorage.setItem(attributeName, value)
// }

// function permaLoad(attributeName){
//   return JSON.parse(window.localStorage.getItem(attributeName))
// }

// function permaLoadText(attributeName){
//   return window.localStorage.getItem(attributeName)
// }

function permaSave(attributeName, value){
  window.localStorage.setItem(attributeName, value)
}

function permaLoad(attributeName){
  return window.localStorage.getItem(attributeName)
}

//makeEasyTable();
//makeAdvancedTable();
//makeExtremeTable();
//colourAllZeroedInnerText();  // It's not necessary to use this function here because it is also called in colorClicked data
//checkGameFinished();
//delegate(table, 'td', 'click', colorClickedData)



const resetButton = document.querySelector('#reset');
resetButton.disabled = true;
resetButton.style.display = 'none';
resetButton.addEventListener('click',resetGameFunction);

const saveButton = document.querySelector('#save');
saveButton.style.display = 'none';
saveButton.addEventListener('click', gettingBulbsForSaving);
saveButton.disabled = true;

const resumeButton = document.querySelector('#resume');
//newGameButton.disabled = true;
resumeButton.addEventListener('click', makeMapForResume);

const newGameButton = document.querySelector('#newGame');
//newGameButton.disabled = true;
newGameButton.addEventListener('click', newGame);

const easyGameButton = document.querySelector('#easy');
easyGameButton.addEventListener('click', newGameEasy);

const advancedGameButton = document.querySelector('#advanced');
advancedGameButton.addEventListener('click', newGameAdvanced);

const extremeGameButton = document.querySelector('#extreme');
extremeGameButton.addEventListener('click', newGameExtreme);




// console.log(resetButton);

// const auxTableLen = 7;
// const auxInnerIndex = 19;
// const auxMaxIndex = 48;

// console.log(checkAdjacentPossibilityForPlacing(auxTableLen,auxInnerIndex,auxMaxIndex));
// console.log(checkAdjacent(auxTableLen,auxInnerIndex,auxMaxIndex));


