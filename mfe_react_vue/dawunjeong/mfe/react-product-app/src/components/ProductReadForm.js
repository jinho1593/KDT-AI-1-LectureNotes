import React from 'react'
import {Link} from 'react-router-dom'

const ProductReadForm = ({ productId, product, isLoading, onRemove }) => {
  return (
    <div>
      <h2>상품 조회</h2>
      { isLoading && "로딩중 ..........." }
      { !isLoading && product && (
        <>
        <table border="1">
            <tbody>
                <tr>
                  <td>번호</td>
                  <td>
                    <input type="text" value={ product.productId } readOnly/>
                  </td>
                </tr>
                <tr>
                  <td>상품명</td>
                  <td>
                    <input type="text" value={ product.name } readOnly/>
                  </td>
                </tr>
                <tr>
                  <td>가격</td>
                  <td>
                    <input type="text" value={ product.price } readOnly/>
                  </td>
                </tr>
                <tr>
                  <td>제조사</td>
                  <td>
                    <input type="text" value={ product.manufacturer } readOnly/>
                  </td>
                </tr>
                <tr>
                  <td>유통기한</td>
                  <td>
                    <input type="text" value={ product.expirationDate } readOnly/>
                  </td>
                </tr>
                <tr>
                  <td>제조일자</td>
                  <td>
                    <input type="text" value={ product.productionDate } readOnly/>
                  </td>
                </tr>
                <tr>
                  <td>상품정보</td>
                  <td>
                    <textarea value={ product.details } readOnly/>
                  </td>
                </tr>
            </tbody>
          </table>

          <Link to={`/modify/${productId}`}>수정</Link>
            <button onClick={onRemove}>삭제</button>
            <Link to="/">돌아가기</Link>
        </>
      )}
    </div>
  )
}

export default ProductReadForm