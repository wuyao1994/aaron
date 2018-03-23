import React from 'react'
import ReactEcharts from 'echarts-for-react'
import echarts from 'echarts'

const TreeBasicComponent = () => {
  const data = {
    "name": "fergusoon",
    "children": [
      {
        "name": "breakfix",
        "children": [
          {
            "name" : "b3.2.31",
            "children": [
              {"name":"e3.2.30"},
              {
                "name":"b3.2.30",
                "children": [
                  {
                    "name":"b3.2.29",
                    "children": [
                      {
                        "name":"b3.2.28",
                        "children":[
                          {
                            "name":'b3.2.27',
                          }
                        ],
                      },
                      {
                        "name":"e.3.2.27",
                      }
                    ]
                  }
                ]
              },
              {"name":'v3.2.31'}
            ]
          }
        ]
      },
      {
        "name": "enhancement",
        "children": [
          {
            "name" :"e3.2.31",
            "children": [
              {
                "name":"e3.2.30",
                "children":[
                  {
                    "name":"e3.2.29",
                  }
                ]
              },
              {"name":"b3.2.31"}
            ]
          }
        ]
      },
      {
        "name": "boba",
        "children": [
          {"name": "v3.2.21", "value": 7074}
        ]
      }
    ],
  }

  const option = {
    tooltip: {
      trigger: 'item',
      triggerOn: 'mousemove'
    },
    series: [
      {
        type: 'tree',

        data: [data],

        top: '1%',
        left: '7%',
        bottom: '1%',
        right: '20%',

        symbolSize: 7,

        label: {
          normal: {
            position: 'left',
            verticalAlign: 'middle',
            align: 'right',
            fontSize: 9
          }
        },

        leaves: {
          label: {
            normal: {
              position: 'right',
              verticalAlign: 'middle',
              align: 'left'
            }
          }
        },

        expandAndCollapse: true,
        animationDuration: 550,
        animationDurationUpdate: 750
      }
    ]
  }

  return (
    <div className="examples">
      <div className="parent">
        <ReactEcharts
          option={option}
          style={{ height: '500px', width: '100%' }}
          className="react_for_echarts"
        />
      </div>
    </div>
  )
}

export default TreeBasicComponent
