import React from 'react'
import ReactEcharts from 'echarts-for-react'

const TreeBasicComponent = () => {
  const data = {
    name: 'fergusoon',
    children: [
      {
        name: 'Hunter',
        children: [
          {
            name: 'tag-b3.2.43',
            children: [
              {
                name: 'tag-b3.2.42',
                children: [
                ],
              },
            ],
          },
        ],
      },
      {
        name: 'Enhancement',
        children: [
          {
            name: 'tag-e3.2.36',
            children: [
              {
                name: 'tag-e3.2.35',
                children: [
                  {
                    name: 'tag-e3.2.34',
                    children: [
                    ],
                  },
                  {
                    name: 'tag-v3.4.5',
                  },
                ],
              },
              {
                name: 'tag-v3.4.9.2',
              },
            ],
          },
        ],
      },
      {
        name: 'Online',
        children: [
          {
            name: 'tag-v3.4.9.2',
            children: [
              {
                name: 'tag-v3.4.9.1',
                children: [
                  {
                    name: 'tag-v3.4.9',
                    children: [
                      {
                        name: 'tag-v3.4.8',
                        children: [
                          {
                            name: 'tag-v3.4.7',
                            children: [
                              {
                                name: 'tag-v3.4.6',
                                children: [
                                  {
                                    name: 'tag-v3.4.5',
                                  },
                                ],
                              },
                            ],
                          },
                        ],
                      },
                    ],
                  },
                ],
              },
            ],
          },
        ],
      },
      {
        name: 'Boba',
        children: [
          {
            name: 'tag-f3.2.27.1',
            children: [
              {
                name: 'tag-f3.2.27',
                children: [
                  {
                    name: 'tag-f3.2.26',
                  },
                ],
              },
            ],
          },
        ],
      },
      {
        name: 'PollardWater',
        children: [
          {
            name: 'tag-p3.3.4',
            children: [
              {
                name: 'tag-p3.3.3',
                children: [
                  {
                    name: 'tag-p3.3.2',
                    children: [
                    ],
                  },
                ],
              },
            ],
          },
        ],
      },
    ],
  }

  const option = {
    tooltip: {
      trigger: 'item',
      triggerOn: 'mousemove',
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
            fontSize: 9,
          },
        },

        leaves: {
          label: {
            normal: {
              position: 'right',
              verticalAlign: 'middle',
              align: 'left',
            },
          },
        },

        expandAndCollapse: true,
        animationDuration: 550,
        animationDurationUpdate: 750,
      },
    ],
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
