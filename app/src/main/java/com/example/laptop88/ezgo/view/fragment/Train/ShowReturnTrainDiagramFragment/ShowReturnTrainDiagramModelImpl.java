package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment;

import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.SeatStorageApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowReturnTrainDiagramModelImpl implements ShowReturnTrainDiagramModel {
    private ShowReturnTrainDiagramPresenter mShowReturnTrainDiagramFragmentPresenter;
    private ApplicationApi mApplicationApi;

    public ShowReturnTrainDiagramModelImpl(ShowReturnTrainDiagramPresenter showReturnTrainDiagramFragmentPresenter) {
        if (mApplicationApi == null){
            mApplicationApi = new ApplicationApi();
        }
        mShowReturnTrainDiagramFragmentPresenter = showReturnTrainDiagramFragmentPresenter;
    }

    @Override
    public void addSeatStorage(SeatStorage seatStorage) {
        Call<SeatStorageResponse> call = mApplicationApi.getClient().create(SeatStorageApi.class).addSeatStorage(seatStorage);
          call.enqueue(new Callback<SeatStorageResponse>() {
              @Override
              public void onResponse(Call<SeatStorageResponse> call, Response<SeatStorageResponse> response) {
                  SeatStorageResponse seatStorageResponse= response.body();
                  int code = Integer.parseInt(seatStorageResponse.getError().getCode());

                  switch (code) {
                      case Constants.HTTPCodeResponse.SUCCESS:
                          mShowReturnTrainDiagramFragmentPresenter.addSeatStorageSuccess(seatStorageResponse);

                          break;
                      default:
                          mShowReturnTrainDiagramFragmentPresenter.addSeatStorageFalse();
                          break;
                  }
              }

              @Override
              public void onFailure(Call<SeatStorageResponse> call, Throwable t) {
                  mShowReturnTrainDiagramFragmentPresenter.addSeatStorageFalse();
              }
          });

    }

    @Override
    public void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest) {
        Call<SeatStorageResponse> call = mApplicationApi.getClient().create(SeatStorageApi.class).deleteSeatStorage(seatStorageDeleteRequest);
        call.enqueue(new Callback<SeatStorageResponse>() {
            @Override
            public void onResponse(Call<SeatStorageResponse> call, Response<SeatStorageResponse> response) {
                SeatStorageResponse seatStorageResponse= response.body();
                int code = Integer.parseInt(seatStorageResponse.getError().getCode());

                switch (code) {
                    case Constants.HTTPCodeResponse.SUCCESS:
                        mShowReturnTrainDiagramFragmentPresenter.deleteSeatStorageSuccess(seatStorageResponse);

                        break;
                    default:
                        mShowReturnTrainDiagramFragmentPresenter.deleteSeatStorageFalse();
                        break;
                }
            }

            @Override
            public void onFailure(Call<SeatStorageResponse> call, Throwable t) {
                mShowReturnTrainDiagramFragmentPresenter.deleteSeatStorageFalse();
            }
        });
    }
}
